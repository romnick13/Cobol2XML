/*
 * @(#)XMLPayload.java	 0.1.0
 *
 * Copyright (c) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */package XMLWriter;

import cobol.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
//import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLPayload {
	Document doc;
	Element rootElement;
	
	public XMLPayload() {
		try {
		DocumentBuilderFactory dbFactory =
		         DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = 
		            dbFactory.newDocumentBuilder();
		doc = dBuilder.newDocument();
		
		 // root element
        rootElement = doc.createElement("cobol");
        doc.appendChild(rootElement);
		
		 } catch (Exception e) {
	         e.printStackTrace();
	     }
		
	}
	
	
	public void addElements(Cobol c) {
		
		/*
		 * add call elements
		 */
		String callMethod = c.getCall();
		if (callMethod != null) 
		{
			this.addCallFunction( callMethod, c.getUsing());
			//System.out.println("call elements"); 
			//Add contents of procedure division
		}
		else 
		{
			//System.out.println("call null");
		}	//end method addElements()
		
		/*
		 * add call elements
		 */
		String compute = c.getCompute();
		if (compute != null) 
		{
			this.addCompute( compute);
			//System.out.println("Got compute"); 
			//Add contents of procedure division
		}
		else 
		{
			//System.out.println("compute null");
		}	//end method addElements()
		
		String accept = c.getAccept();
		if (accept != null) 
		{
			this.addAccept(accept);
//			System.out.println(accept);
			
		}
		else 
		{
			//System.out.println("Accept null");
		}
		
		String display = c.getDisplay();
		if (display != null) 
		{
			this.addDisplay(display);
//			System.out.println(display);
			
		}
		else 
		{
			//System.out.println("Display null");
		}
		
		String moveMethod = c.getMove();
		if (moveMethod != null) 
		{
			this.addMoveData(moveMethod);
//			System.out.println(move);
			
		}
		else 
		{
			//System.out.println("Move null");
		}
		
		String hexData = c.getHexData();
		if (hexData != null) 
		{
			this.addHexadecimalData(hexData);
//			System.out.println(commentLine);
			
		}
		else 
		{
			//System.out.println("Hexadecimal null");
		}
		
		String perform = c.getPerform();
		if (perform != null) 
		{
			this.addPerformMethod(perform);;
//			System.out.println(perform);
			//System.out.println("Got Section");  
			// Add contents of procedure division
		}
		else 
		{
			//System.out.println("Perform null");
		}
		
		/*
		 *  add commentLine element
		 */
		String commentLine = c.getCommentLine();
		if (commentLine != null) 
		{
			this.addCommentLineElements(commentLine);
//			System.out.println(commentLine);
			
		}
		else 
		{
			//System.out.println("Comment Line null");
		}
		
		/*
		 * add constants elements
		 */
		String constantName = c.getConstantName();
		if (constantName != null) 
		{
			this.addConstantValueElement( constantName, c.getConstantValue(), c.getLineNumber());
			//System.out.println("Got Section"); 
		}
		else 
		{
			//System.out.println("Constant null");
		}	//end method addElements()
		
		/*
		 *  add sectionName element
		 */		
		String sectionName = c.getSectionName();
		if (sectionName != null) {
			this.addSectionElement( sectionName );
			//System.out.println("Got Section");
		} else {
			//System.out.println("Section Name null");
		}
		
		/*
		 *  add divisionName element
		 */		
		String divisionName = c.getDivisionName();
		if (divisionName != null) {
			this.addDivisionElement( divisionName );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Division Name null");
		}
		
		String remarkComment = c.getRemarks();
		if (remarkComment != null) {
			this.addRemarksComment(remarkComment);
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Division Name null");
		}
		
		/*
		 *  add ProgramID element
		 */		
		String programIDName = c.getProgram_ID();
		if (programIDName != null) {
			this.addProgram_IDElement( programIDName );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Section Name null");
		}
		
		/*
		 *  add DateWritten element
		 */	
		// DayDateWritten
		int dayDateWritten = c.getDayDateWritten();
		if(dayDateWritten != 0) {
			this.addDayDateWrittenElement( dayDateWritten );
		}
		
		//MonthDateWritten
		String monthDateWritten = c.getMonthDateWritten();
		if (monthDateWritten != null) {
			this.addMonthDateWrittenElement( monthDateWritten );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Section Name null");
		}

		// YearDateWritten
		int yearDateWritten = c.getYearDateWritten();
		if(yearDateWritten != 0) {
			this.addYearDateWrittenElement( yearDateWritten );
		}

	}
	

 	void addProgram_IDElement(String stringElement) {
		//  Program ID element
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("Program-ID");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
 	void addSectionElement(String stringElement) {
		//  Section element
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("section");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
 	void addDivisionElement(String stringElement) {
		//  Division element
		if(stringElement != null) {
			Element cobolname = doc.createElement("division");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
	
	void addDayDateWrittenElement(int intElement) {
		//  DayDateWritten element
		
		if(intElement != 0) {
			Element cobolname = doc.createElement("day-date-written");
			String s = "" + intElement;
			cobolname.appendChild(doc.createTextNode(s));
			rootElement.appendChild(cobolname);
		}
	}
 	
	void addMonthDateWrittenElement(String stringElement) {
		//  MonthWritten element
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("month-date-written");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}

	void addYearDateWrittenElement(int intElement) {
		//  YearDateWritten element
		
		if(intElement != 0) {
			Element cobolname = doc.createElement("year-date-written");
			String s = "" + intElement;
			cobolname.appendChild(doc.createTextNode(s));
			rootElement.appendChild(cobolname);
		}
	}
	
	public void writeFile(String filename) {
		try {
		// write the content into xml file
		// System.out.println("WriteFile Filename: " + filename);
        TransformerFactory transformerFactory =
        TransformerFactory.newInstance();
        Transformer transformer =
        transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        
        StreamResult result =
                new StreamResult(new File(filename));
        transformer.transform(source, result);
        
        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
        
		 } catch (Exception e) {
	         e.printStackTrace();
	     }
	}
	
	void addConstantValueElement(String constantName,  double constantValue, int lineNumber) 
	{
		//  ConstantValueElement
		if(constantName != null) 
		{
			Element cobolname = doc.createElement("Constant"); 
			
			//insert name of constant into XML file
			Element constID = doc.createElement("Constant");   
			Attr attrType2 = doc.createAttribute("Name" );   
			attrType2.setValue(constantName );   
			constID.setAttributeNode(attrType2);   
			cobolname.appendChild(constID);
			
			// insert line number of constant into XML file
			Element lineID = doc.createElement(constantName);   
			Attr attrType = doc.createAttribute("Line_Number" );   
			attrType.setValue(Integer.toString(lineNumber) );   
			lineID.setAttributeNode(attrType);   
			cobolname.appendChild(lineID);
			
			// insert value of constant into XML file
			Element constantID = doc.createElement(constantName);
			Attr attrType1 = doc.createAttribute("Value");
			attrType1.setValue(Double.toString(constantValue));
			constantID.setAttributeNode(attrType1);
			cobolname.appendChild(constantID);
			
			rootElement.appendChild(cobolname);
		}
	}
	
	void addCommentLineElements(String stringElement) 
	{
		//Comment Line element
		if (stringElement != null) 
		{
			Element cobolname = doc.createElement("all_comments");
			//create sub-element
			Element element = doc.createElement("comment");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	}
	
	void addRemarksComment(String stringElement) {
		if(stringElement != null) {
			Element cobolname = doc.createElement("remarks");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
	
	void addPerformMethod(String stringElement) {
		//Perform elements
		if (stringElement != null) {
			Element cobolname = doc.createElement("perform");
			//create sub-element
			Element element = doc.createElement("method");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	}
	
	void addHexadecimalData(String stringElement) {
		//Hexadecimal elements
		if (stringElement != null) {
			Element cobolname = doc.createElement("hex_dec_data");
			//create sub-element
			Element element = doc.createElement("hex");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	}
	
	void addMoveData(String stringElement) 
	{
		//Move elements
		if (stringElement != null) {
			Element cobolname = doc.createElement("move_function");
			//create sub-element
			Element element = doc.createElement("method");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	}
	
	void addDisplay(String stringElement) 
	{
		//Display elements
		if (stringElement != null) {
			Element cobolname = doc.createElement("display_function");
			
			Element element = doc.createElement("method");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	}
	
	void addAccept(String stringElement) 
	{
		//Accept elements
		if (stringElement != null) {
			Element cobolname = doc.createElement("accept_funtion");
			
			Element element = doc.createElement("method");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	}

	void addCallFunction(String call,  String using) 
	{
		//Call elements
		if(call != null) 
		{
			Element cobolname = doc.createElement("Call_Method"); 
			
			//insert variable used into XML file
			Element var = doc.createElement("call");   
			Attr attrType2 = doc.createAttribute("var_used" );   
			attrType2.setValue(call );   
			var.setAttributeNode(attrType2);   
			cobolname.appendChild(var);
			
			//insert method used
			Element method = doc.createElement("call");   
			Attr attrType = doc.createAttribute("method" );   
			attrType.setValue(using );   
			method.setAttributeNode(attrType);   
			cobolname.appendChild(method);
					
			rootElement.appendChild(cobolname);
		}
	}
	
	void addCompute(String stringElement) 
	{
		//Compute elements
		if (stringElement != null) {
			Element cobolname = doc.createElement("compute");
			//create sub-elements
			Element element = doc.createElement("method");         
			element.setTextContent(stringElement);
			cobolname.appendChild(element);
			
			rootElement.appendChild(cobolname);
		}
	} 
}

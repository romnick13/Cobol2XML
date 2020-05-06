/*
 * @(#)CobolParser.java	 0.1.0
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
 */
package cobol;

import parse.Alternation;
import parse.Empty;
import parse.Parser;
import parse.Sequence;
import parse.tokens.CaselessLiteral;
import parse.tokens.Num;
import parse.tokens.QuotedString;
import parse.tokens.Symbol;
import parse.tokens.Tokenizer;
import parse.tokens.Word;

public class CobolParser {
	/**
	 * Return a parser that will recognize the selected COBOL source code constructs:
	 * 
	 * 
	 * This parser creates a <code>COBOL</code> object
	 * as an assembly's target.
	 *
	 * @return a parser that will recognize and build a 
	 *         <object>COBOL</object> from a source code file.
	 */
	public Parser cobol() {
		Alternation a = new Alternation();
		
		Symbol fullstop = new Symbol('.');
		fullstop.discard();
		
		a.add( CommentLine());
		
		a.add( ConstantValue());
		
		a.add( ProgramID() );
		
		a.add( DivisionName() );
		
		a.add( SectionName() );
		
		a.add( DateWritten() );
		
		a.add( PerformMethod());
		
		a.add( HexadecimalData());
		
		a.add( MoveFunction());
		
		a.add( DisplayFunction());
		
		a.add( AcceptFunction());
		
		a.add( CallMethod());
		
		a.add( ComputeMethod());
		
		a.add(new Empty());
		return a;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Compute = Word;
	 *
	 */
	protected Parser ComputeMethod() {
		Sequence s = new Sequence() ;
		s.add(new CaselessLiteral("compute") );
		s.add(new Word());
		s.setAssembler(new ComputeAssembler());
		return s;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Call Function = Word;
	 *
	 */
	protected Parser CallMethod() {
		Sequence s = new Sequence() ;
		s.add(new CaselessLiteral("call") );
		s.add(new QuotedString());
		s.add(new Word());
		s.setAssembler(new CallAssembler());
		return s;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Accept Function = Word;
	 *
	 */
	protected Parser AcceptFunction() 
	{
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("accept"));
		s.add(new Word().setAssembler(new AcceptAssembler()));
		return s;
	}
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Display Function = Word;
	 *
	 */
	protected Parser DisplayFunction() 
	{
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("display"));
		s.add(new QuotedString());
		s.setAssembler(new DisplayAssember());
		return s;
	}
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *   Move Function = Word;
	 *
	 */
	protected Parser MoveFunction() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("move"));
		s.add(new Word());
		s.setAssembler(new MoveAssembler());
		return s;
	}
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Hexadecimal Data = Word;
	 *
	 */
	protected Parser HexadecimalData() {
		Sequence s = new Sequence();
		s.add(new QuotedString());
		s.add(new Symbol('.').discard());
		s.setAssembler(new HexDataAssembler());
		return s;
	}
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Program Identifier = Word;
	 *
	 */
	protected Parser PerformMethod() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("perform"));
		s.add(new Word().setAssembler(new PerformAssembler()));
		return s;	
	}	

	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Program Identifier = Word;
	 *
	 */
	protected Parser ProgramID() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("program-id") );
		s.add(new Symbol('.').discard());	
		s.add(new Word().setAssembler(new Program_idAssembler()));
		return s;
	}



	/*
	 * Return a parser that will recognise the grammar:
	 * 
	 *    <divisionName> division;
	 *
	 */
	protected Parser DivisionName() {
		Sequence s = new Sequence();
		s.add(new Word().setAssembler(new DivisionAssembler()));
		s.add(new CaselessLiteral("division") );
		s.add(new Symbol('.').discard());
		return s;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Program Identifier = Word;
	 *
	 */
	protected Parser SectionName() {
		Sequence s = new Sequence();
		s.add(new Word().setAssembler(new SectionNameAssembler()));
		s.add(new CaselessLiteral("section") );
		s.add(new Symbol('.').discard());	

		return s;
	}
	
	/*
	 * Return a parser that will recognise the grammar:
	 * 
	 *    working-storage section;
	 *
	 */
	protected Parser DateWritten() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("date-written") );
		s.add(new Symbol('.').discard());
		s.add(new Num());
		s.add(new Symbol('-').discard());

		//This next Word actually contains month and year (which are extracted in DateAssembler
		s.add(new Word());
		s.add(new Symbol('-').discard());
		s.add(new Word().discard());
		s.add(new Symbol('.').discard());
		s.setAssembler(new DateAssembler());
		return s;
	}


	/**
	 * Return the primary parser for this class -- cobol().
	 *
	 * @return the primary parser for this class -- cobol()
	 */
	public static Parser start() {
		return new CobolParser().cobol();
	}

	/**
	 * Returns a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol's grammar.
	 *
	 * @return a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol grammar.
	 */
	public static Tokenizer tokenizer() {
		Tokenizer t = new Tokenizer();
		t.wordState().setWordChars(' ', ' ', false);
		return t;
	}
	
	/*  
	 * Return a parser that will recognize the grammar:  
	 *   
	 *    <line number> <contstant name> "value" <constant value>.  
	 */
	protected Parser ConstantValue() 
	{
		//System.out.println("constantValueAssembler()");
		Sequence s = new Sequence();
		s.add(new Num());
		s.add(new Word());
		s.add(new CaselessLiteral("value"));
		s.add(new Num());
		s.setAssembler(new ConstantValueAssembler());
		return s;
	}
	
	protected Parser CommentLine() 
	{
		Sequence s = new Sequence();
		s.add(new Symbol("*"));
		s.add(new Symbol("*"));
		s.add(new Symbol("*"));
		s.add(new Symbol("-"));
		s.add(new Symbol("-"));
		s.add(new Symbol("-"));
		
		s.add(new Word().setAssembler(new CommentLineAssembler()));		
		//s.setAssembler(new CommentLineAssembler());
		
		//System.out.println(s.getSubparsers().toString());
		return s;
	}

}

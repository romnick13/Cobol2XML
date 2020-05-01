import static org.junit.Assert.*;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class DisplayTests {

	@Test
	public void displayParseStringOne() {

		String strOne = "\"Base:  \" no";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("display " + strOne);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "\"Base:  \" no";
		
		assertNotNull(c.getDisplay());
		assertEquals(c.getDisplay() , result);
	}
	
	@Test
	public void displayParseStringTwo() {

		String strTwo = "\"Value:  \" no";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("display " + strTwo);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "\"Value:  \" no";
		
		assertNotNull(c.getDisplay());
		assertEquals(c.getDisplay() , result);
	}
	
	@Test
	public void displayParseStringThree() {

		String strThree = "\"Decimal  value:  \" entry_char";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("display " + strThree);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "\"Decimal  value:  \" entry_char";
		
		assertNotNull(c.getDisplay());
		assertEquals(c.getDisplay() , result);
	}
	
	@Test
	public void displayParseStringFour() {

		String strFour = "\"Base: \" current_base \" value: \" entry_char";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("display " + strFour);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "\"Base: \" current_base \" value: \" entry_char";
		
		assertNotNull(c.getDisplay());
		assertEquals(c.getDisplay() , result);
	}

}

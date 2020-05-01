import static org.junit.Assert.*;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class PerformTests {

	@Test
	public void performParseStringOne() {
		
		String strOne = "base-to-decimal thru base-to-decimal-ex";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("perform " + strOne);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "base-to-decimal thru base-to-decimal-ex";
		
		assertNotNull(c.getPerform());
		assertEquals(c.getPerform() , result);
			
	}
	
	@Test
	public void performParseStringTwo() {
		
		String strTwo = "decimal-to-base thru decimal-to-base-ex";

		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("perform " + strTwo);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "decimal-to-base thru decimal-to-base-ex";
		
		assertNotNull(c.getPerform());
		assertEquals(c.getPerform() , result);
			
	}
	
	@Test
	public void performParseStringThree() {
		
		String strThree = "until w_number < current_base";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("perform " + strThree);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "until w_number < current_base";
		
		assertNotNull(c.getPerform());
		assertEquals(c.getPerform() , result);
			
	}
	
	@Test
	public void performParseStringFour() {
		
		String testFour = "test after varying ind from 1.0 by 1.0 until ind = 16.0";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("perform " + testFour);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "test after varying ind from 1.0 by 1.0 until ind = 16.0";
		
		assertNotNull(c.getPerform());
		assertEquals(c.getPerform() , result);
			
	}

}

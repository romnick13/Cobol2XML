import static org.junit.Assert.*;

import org.junit.Test;

import cobol.CobolParser;
import parse.Parser;
import cobol.Cobol;
import parse.Assembly;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class DivisionTests {

	@Test
	public void testDivisionName1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("identification division.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertEquals(c.getDivisionName(), "identification");
	}
	
	@Test
	public void testDivisionName2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("data division.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getDivisionName());
		assertEquals(c.getDivisionName(), "data");
	}
	
	@Test
	public void testDivisionName3() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("procedure division.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getDivisionName());
		assertEquals(c.getDivisionName(), "procedure");
	}

}

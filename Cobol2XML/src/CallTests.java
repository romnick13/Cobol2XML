import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class CallTests {

	@Test
	public void testCallMethod1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    call \"c$justify\" using entry_char \"R\".");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getUsing());
		assertEquals(c.getUsing(), " entry_char \"R\" .");
	}
	
	@Test
	public void testCallMethod2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    call \"c$toupper\" using entry_char, value 16.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getUsing());
		assertEquals(c.getUsing(), " entry_char , value 16.0");
	}
	
	@Test
	public void testCallVariable1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    call \"c$justify\" using entry_char \"R\".");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getCall());
		assertEquals(c.getCall(), "\"c$justify\"");
	}
	
	@Test
	public void testCallVariable2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    call \"c$toupper\" using entry_char, value 16.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getCall());
		assertEquals(c.getCall(), "\"c$toupper\"");
	}
}

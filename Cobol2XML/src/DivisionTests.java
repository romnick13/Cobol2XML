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
	public void testDivisionID() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("identification division.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertEquals(c.getDivisionName(), "identification");
	}

}

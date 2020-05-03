import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class ProgramIDTests {
	
	@Test
	public void testProgramID() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("program-id.  base.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getProgram_ID());
		assertEquals(c.getProgram_ID(), "base");
	}
}

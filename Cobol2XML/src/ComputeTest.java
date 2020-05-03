import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class ComputeTest {

	@Test
	public void displayCompute() {
		String compute = "w_number=w_number+rest_divide*current_base**(16.0-ind)";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("compute " + compute);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "w_number=w_number+rest_divide*current_base**(16.0-ind)";
		
		assertNotNull(c.getCompute());
		assertEquals(c.getCompute(), result);
	}
}

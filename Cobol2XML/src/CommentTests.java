import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class CommentTests {

	@Test
	public void testComment1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("***---  convert from decimal to base system");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getCommentLine());
		assertEquals(c.getCommentLine(), "convert from decimal to base system");
		
	}
	
	@Test
	public void tesComment2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("***---  convert from base to dicimal system");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getCommentLine());
		assertEquals(c.getCommentLine(), "convert from base to dicimal system");
		
	}
	
	@Test
	public void tesComment3() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("***--- allineamento a destra della variabile entry_char (ver 2.3.1 o sup)");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getCommentLine());
		assertEquals(c.getCommentLine(), "allineamento a destra della variabile entry_char ( ver 2.3 0.1 o sup )");
		
	}
}

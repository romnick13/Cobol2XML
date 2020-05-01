import static org.junit.Assert.*;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class AcceptTests {

	@Test
	public void acceptStringOneTest() {
		
		String strOne = "current_base convert";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("accept " + strOne);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "current_base convert";
		
		assertNotNull(c.getAccept());
		assertEquals(c.getAccept() , result);
			
	}
	
	@Test
	public void acceptStringTwoTest() {
		
		String strTwo = "entry_char ";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("accept " + strTwo);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "entry_char "; 
		
		assertNotNull(c.getAccept());
		assertEquals(c.getAccept() , result);
			
	}
	
	@Test
	public void acceptStringThreeTest() {
		
		String strThree = "omitted ";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("accept " + strThree);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "omitted ";
		
		assertNotNull(c.getAccept());
		assertEquals(c.getAccept() , result);
			
	}

}

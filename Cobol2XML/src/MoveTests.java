import static org.junit.Assert.*;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class MoveTests {

	@Test
	public void moveParseStringOne() {

		String strOne = "entry_number to w_number";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("move " + strOne);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "entry_number to w_number";
		
		assertNotNull(c.getMove());
		assertEquals(c.getMove() , result);
	}
	
	@Test
	public void moveParseStringTwo() {

		String strTwo = "spaces to entry_char";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("move " + strTwo);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "spaces to entry_char";
		
		assertNotNull(c.getMove());
		assertEquals(c.getMove() , result);
	}
	
	@Test
	public void moveParseStringThree() {

		String strThree = "hex_value ( hex_idx ) to entry_char ( ind : 1.0 )";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("move " + strThree);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "hex_value ( hex_idx ) to entry_char ( ind : 1.0 )";
		
		assertNotNull(c.getMove());
		assertEquals(c.getMove() , result);
	}
	
	@Test
	public void moveParseStringFour() {

		String strFour = "w_number to entry_number .";
		
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("move " + strFour);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String result = "w_number to entry_number .";
		
		assertNotNull(c.getMove());
		assertEquals(c.getMove() , result);
	}

}

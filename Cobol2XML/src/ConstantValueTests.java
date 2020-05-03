import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class ConstantValueTests {

	@Test
	public void testConstantValue1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_2                          value 2.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantValue());
		assertEquals(c.getConstantValue(), 2.0, 0.0);
	}
	
	@Test
	public void testConstantName1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_2                          value 2.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantName());
		assertEquals(c.getConstantName(), "base_2");
		
	}
	
	@Test
	public void testLineNumber1() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_2                          value 2.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getLineNumber());
		assertEquals(c.getLineNumber(), 88);
		
	}
	
	@Test
	public void testConstantValue2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_8                          value 8.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantValue());
		assertEquals(c.getConstantValue(), 8.0, 0.0);
	}
	
	@Test
	public void testConstantName2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_8                          value 8.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantName());
		assertEquals(c.getConstantName(), "base_8");
	}
	
	@Test
	public void testLineNumber2() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_8                          value 8.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getLineNumber());
		assertEquals(c.getLineNumber(), 88);
	}
	
	@Test
	public void testConstantValue3() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_10                         value 10.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantValue());
		assertEquals(c.getConstantValue(), 10.0, 0.0);	
	}
	
	@Test
	public void testConstantName3() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_10                         value 10.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantName());
		assertEquals(c.getConstantName(), "base_10");	
	}
	
	@Test
	public void testLineNumber3() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_10                         value 10.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getLineNumber());
		assertEquals(c.getLineNumber(), 88);	
	}
	
	@Test
	public void testConstantValue4() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_16                         value 16.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantValue());
		assertEquals(c.getConstantValue(), 16.0, 0.0);
	}
	
	@Test
	public void testConstantName4() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_16                         value 16.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getConstantName());
		assertEquals(c.getConstantName(), "base_16");
	}
	
	@Test
	public void testLineNumber4() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("    88  base_16                         value 16.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getLineNumber());
		assertEquals(c.getLineNumber(), 88);
	}
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class DateTests {

	@Test
	public void testMonth() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("date-written.  07-mar-1995 - mb.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getMonthDateWritten());
		assertEquals(c.getMonthDateWritten(), "mar");
		
	}
	
	@Test
	public void testYear() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("date-written.  07-mar-1995 - mb.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getYearDateWritten());
		assertEquals(c.getYearDateWritten(), 1995);
		
	}
	
	@Test
	public void testDay() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("date-written.  07-mar-1995 - mb.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertNotNull(c.getDayDateWritten());
		assertEquals(c.getDayDateWritten(), 07);
		
	}
}

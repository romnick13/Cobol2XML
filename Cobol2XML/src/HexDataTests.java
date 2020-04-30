import static org.junit.Assert.*;

import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class HexDataTests {

	@Test
	public void hexaParsingTest() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		t.setString("\"000101202303404505606707808909A10B11C12D13E14F15\".");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		String hexaValue = "000101202303404505606707808909A10B11C12D13E14F15";
		
		assertNotNull(c.getHexData());
		assertEquals(c.getHexData() , hexaValue);
		assertTrue(isHexaNumber(hexaValue));		
		
	}
	
	/**
	 * Test if any of the characters is not a
	 * valid hexadecimal digit.
	 */
	private static boolean isHexaNumber(String hexaString) {
	    if ( hexaString.length() == 0 || 
	         (hexaString.charAt(0) != '-' && Character.digit(hexaString.charAt(0), 16) == -1))
	        return false;
	    if ( hexaString.length() == 1 && hexaString.charAt(0) == '-' )
	        return false;

	    for ( int i = 1 ; i < hexaString.length() ; i++ )
	        if ( Character.digit(hexaString.charAt(i), 16) == -1 )
	            return false;
	    return true;
	}

}

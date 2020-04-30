package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class HexDataAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {

		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		
		c.setHexData(t.sval().trim().substring(1, t.sval().length() - 1));
		a.setTarget(c);
	}

}

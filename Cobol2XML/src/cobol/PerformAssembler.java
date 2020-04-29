package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class PerformAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {
		// TODO Auto-generated method stub
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		
		if(t.sval() != null) {
			c.setPerform(t.sval().trim()+ defaultDelimiter() + a.remainder(defaultDelimiter()));
			a.setTarget(c); 
		}
	}

	public String defaultDelimiter() {
		String delimiter = " ";
		return delimiter; 
	}

}

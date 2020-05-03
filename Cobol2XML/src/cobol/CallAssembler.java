package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class CallAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		
		if(t.sval() != null) {
			t = (Token) a.pop();
			c.setUsing(defaultDelimiter() + a.remainder(defaultDelimiter()));
			//System.out.println("using value test: "+ defaultDelimiter() + a.remainder(defaultDelimiter()));
		}
		
		c.setCall(t.sval());
		//System.out.println("callVar " + t.sval());
		
		a.setTarget(c);
	}

	public String defaultDelimiter() {
		String delimiter = " ";
		return delimiter; 
	}

}

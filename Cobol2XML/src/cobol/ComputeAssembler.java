package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class ComputeAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {
		// TODO Auto-generated method stub
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		
		if(t.sval() != null) {
			c.setCompute(t.sval().trim()+ a.remainder(defaultDelimiter()));
			a.setTarget(c); 
		}
		//System.out.println("test:" + t.sval().trim()+ a.remainder(defaultDelimiter()));
	}

	public String defaultDelimiter() {
		String delimiter = "";
		return delimiter; 
	}
	

}

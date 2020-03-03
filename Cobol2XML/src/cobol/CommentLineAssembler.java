package cobol;

import parse.*;
import parse.tokens.*;
public class CommentLineAssembler extends Assembler {
	/**  
	 * Pop a string, and set the target DataDivision to this  
	 * string.  
	 *  
	 * @param   Assembly   the assembly to work on  
	 */
	@Override
	public void workOn(Assembly a) {
		//System.out.println("commentLineAssembler");
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		
		if(t.sval() != null) {
			c.setCommentLine(t.sval().trim()+ defaultDelimiter() + a.remainder(defaultDelimiter()));
			a.setTarget(c); }
		}

		public String defaultDelimiter() {
		String delimiter = " ";
		return delimiter; 
		}
	
	
}

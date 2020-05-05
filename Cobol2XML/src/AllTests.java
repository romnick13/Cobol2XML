import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AcceptTests.class, CallTests.class, CommentTests.class, ComputeTest.class, ConstantValueTests.class,
		DateTests.class, DisplayTests.class, DivisionTests.class, HexDataTests.class, MoveTests.class,
		PerformTests.class, ProgramIDTests.class, SectionTests.class })
public class AllTests {

}

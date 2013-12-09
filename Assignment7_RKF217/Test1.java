import java.io.IOException;
import java.util.List;

/*
 * Test if CWSolution can handle a null parameter for constructor
 */
public class Test1 extends TestHarness {

	public Test1(String s) { super(s); }

	public boolean test() {
		FileParser fp = null;
		try {
			fp = new FileParser("TWL06.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			//e2.printStackTrace();
		}
		List<String> dict = null;
		try {
			dict = fp.getAllWords();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		
		
		
		
		try {
			CWSolution c = new CWSolution(null);

			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
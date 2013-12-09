import java.io.IOException;
import java.util.List;

/*
 * Test2 - Tests if CWSolution returns the right amount with max and min Values
 */
public class Test4 extends TestHarness {

	public Test4(String s) { super(s); }

	public boolean test() {
		FileParser fp = null;
		try {
			fp = new FileParser("TWL06.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		List<String> dict = null;
		try {
			dict = fp.getAllWords();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		try {
			CWSolution c = new CWSolution(dict);
			List ll = c.solutions("******", Integer.MAX_VALUE);
			if(!(ll.size()>1000)){
				System.out.println(ll.size());
				return false;
			}
			List ll2 = c.solutions("******", Integer.MIN_VALUE);
			if(ll2.size()!=0){
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
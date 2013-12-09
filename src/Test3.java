import java.io.IOException;
import java.util.List;

/*
 * Test2 - Tests if CWSolution returns the right amount of solutions
 */
public class Test3 extends TestHarness {

	public Test3(String s) { super(s); }

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
			CWSolution c = new CWSolution(dict);
			List ll = c.solutions("*S**", 1000);
			if(ll.size()!=21){
				return false;
			}
			List ll2 = c.solutions("*F**", 1000);
			if(ll2.size()!=8){
				return false;
			}
			List ll3 = c.solutions("XX", 1000);
			if(ll3.size()!=0){
				return false;
			}
			List ll4 = c.solutions("*****", 1000);
			if(ll4.size()!=1000){
				return false;
			}
			//****************
			List ll5 = c.solutions("****************", 1000);
			if(ll5.size()!=0){
				return false;
			}
			List ll6 = c.solutions("", 1000);
			if(ll6.size()!=0){
				return false;
			}
			List ll7 = c.solutions("***", 0);
			if(ll7.size()!=0){
				return false;
			}
			List ll8 = c.solutions("*T*SS", 3);
			if(ll8.size()!=1){
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
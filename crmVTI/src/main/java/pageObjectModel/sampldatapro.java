package pageObjectModel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sampldatapro {
	@DataProvider(name="data")
	public Object[] dat() {
		Object[] s= {"demo","sample","manual","sql"};
		
		return  s;
		
		
	}
	@Test(dataProvider = "data")
	public void test(String s) {
		System.out.println(s);
	}

}

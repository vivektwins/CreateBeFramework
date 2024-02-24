package api.payload;

import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name = "test-data")
	public static Object[][] dp()
	{
		Object a = 10;
		return new Object[][]{
			
			{"test1"},{"test2"},{a}
		};
	}
}

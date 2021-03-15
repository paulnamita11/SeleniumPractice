package ToolsQA.DemoSampleProject.test;

import org.testng.annotations.DataProvider;

public class DataForTest {

	@DataProvider(name = "DataForPost")
	public Object[][]  dataForPost() {
		
		/*Object[][] data = new Object[2][3];
		data[0][0] = "Albert";
		data[0][1] = "Henry";
		data[0][2] = "1";
		
		data[1][0] = "Tom";
		data[1][1] = "Henry";
		data[1][2] = c;
		*/
		return new Object[][]  {
			{"Albert", "Henry", "1"},
			{"Tom", "Henry", "2"}
		};
	}
}

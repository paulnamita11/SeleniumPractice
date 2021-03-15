package utils;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		//getRowCount();
		getCellData(0,0);
	}
	
	public static void getRowCount() {

		try {
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows "+rowCount);
			
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
	
}

	public static void getCellData(int rowNum, int colnum) {
		
		try {
			
			String cellData = sheet.getRow(rowNum).getCell(colnum).getStringCellValue();
			System.out.println("Data "+cellData);
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		
		
	}
	
	@Test
	@Parameters({"MyName"})
	public void test(@Optional("Neel") String name) {
		System.out.println("Name is "+name);
		
	}
	
	
}

package dataReader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReaders 
{
	public long excelReader(String path, int sheetno, int rowno, int colno)
	{
		long value = 0;
		try
		{
			FileInputStream file = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheetAt(sheetno);
			value = (long) sheet.getRow(rowno).getCell(colno).getNumericCellValue();
		}
		catch(Exception e)
		{
			System.out.println("issue in reading data : " + e);
		}
		return value;
	}
	public static void main(String[] args) 
	{

		ExcelReaders ob = new ExcelReaders();
		String path = "C:\\Users\\Admin\\eclipse-workspace\\newProject\\TestingData\\Candidate Details.xlsx";
		long output = ob.excelReader(path, 0, 9, 2);
		System.out.println(output);
		
		WebDriver driver = new ChromeDriver();
	}
}

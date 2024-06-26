package dataReader;

import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Voting 
{
	public void votingDay(String name, int age, long output)
	{
		 
		try 
		{
			
			 
			if(age<18)
			{
				throw new Exception("Sorry! you are not eligibel for voting");
			}
			else
			{
				System.out.println("Please choose any one ID for identification");
				System.out.println("Press 1 for Aadhar Card");
				System.out.println("Press 2 for Voter ID Card");
				Scanner sc1 = new Scanner(System.in);
				int num = sc1.nextInt();
				if(num==1)
				{
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Please enter the Aadhar number");
					long aadharNum = sc2.nextLong();
				}
				if(num==2)
				{
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Please enter the Voter ID number");
					long aadharNum = sc2.nextInt();
					if(aadharNum==output)
					{
						System.out.println("Congrats, your aadhar details was found in database");
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			main(null);
		}
	}
	
	public long excelFileReader(String path, int sheetno, int rowno, int colno)
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
		Voting ob = new Voting();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the name");
		String name = sc.nextLine();
		System.out.println("Please enter your age");
		int age = sc.nextInt();
		
		
		
		String path = "C:\\Users\\Admin\\eclipse-workspace\\newProject\\TestingData\\Candidate Details.xlsx";
		long output = ob.excelFileReader(path, 0, 9, 2);
		System.out.println(output);
		ob.votingDay(name, age, output);
		
	}
}

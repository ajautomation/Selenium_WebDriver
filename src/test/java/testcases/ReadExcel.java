package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {

	String cellData;
	public String readExcelData(String excelNamePath,int sheetNumber,int rowNumber, int columnNumber) {
		
	try {
		
		File file=new File(excelNamePath);
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(sheetNumber);
		
		XSSFRow row=sheet.getRow(rowNumber);
		
		XSSFCell cell=row.getCell(columnNumber);
		
		cellData=cell.getStringCellValue();
		
		wb.close();
		
	}catch(IOException io) {
		
		io.printStackTrace();
	}
	
	return cellData;
	
	
	}
	
	
	public static void main(String [] args) {
		
		ReadExcel rb=new ReadExcel();
		
		String value=rb.readExcelData("C:\\Users\\pandi.AJVIVOBOOK\\Downloads\\ReadExcelData.xlsx", 0, 3, 1);
		
		System.out.println("Value we got from the Excel is = " +value);
	}

}


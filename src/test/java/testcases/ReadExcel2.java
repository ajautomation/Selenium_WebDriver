package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel2 {

	String cellData;
	public String readExcelData(String data) {
		
		
		//data=excelPath,0,3,1;
	
	try {
		
		String values []=data.split(",");//excelPath 0 3 1
		
		/*
		 * values[0]=excelPath
		 * values[1]=0
		 * values[2]=3
		 * values[3]=1
		 */
		
		String path=values[0];
		
		int sheetNumber=Integer.valueOf(values[1]);
		int rowNumber=Integer.valueOf(values[2]);
		int columnNumber=Integer.valueOf(values[3]);
		
		
		File file=new File(path);
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(sheetNumber);//o
		
		XSSFRow row=sheet.getRow(rowNumber);//3
		
		XSSFCell cell=row.getCell(columnNumber);//1
		
		cellData=cell.getStringCellValue();
		
		wb.close();
		
	}catch(IOException io) {
		
		io.printStackTrace();
	}
	
	return cellData;
	
	
	}
	
	
	public static void main(String [] args) {
		
		ReadExcel2 rb=new ReadExcel2();
		String excelPath="C:\\Users\\pandi.AJVIVOBOOK\\Downloads\\ReadExcelData.xlsx";
		String value=rb.readExcelData(excelPath+",0,3,1");//"excelPath,0,3,1"
		
		System.out.println("Value we got from the Excel is = " +value);
	}

}


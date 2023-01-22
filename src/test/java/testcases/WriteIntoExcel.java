package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteIntoExcel {

	
	@SuppressWarnings("null")
	public void writeData(String excelPath,String sheetName,int rowNumber, int columnNumber, String data) {
	
	try {
		File file=new File(excelPath);
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		XSSFRow row=sheet.getRow(rowNumber);
		
		XSSFCell cell=row.getCell(columnNumber,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		
		if(cell==null) {
			
			row.createCell(columnNumber);
			
			cell.setCellValue(data);
		
		}else {
			
			cell.setCellValue(data);
		}
		
		FileOutputStream fio=new FileOutputStream(file);
		
		wb.write(fio);
		wb.close();
		
		System.out.println("Write Operation has been completed");
		
		
	}catch(IOException io) {
		io.printStackTrace();
	}
		
	}
	
	
	public static void main(String [] args) {
		
		WriteIntoExcel we=new WriteIntoExcel();
		
		String excelPath="D:\\WriteIntoExcel.xlsx";
		we.writeData(excelPath, "WriteDataSheet", 5, 5, "ABCD");
	}
	
	
	
}

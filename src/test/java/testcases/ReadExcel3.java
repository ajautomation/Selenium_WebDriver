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

public class ReadExcel3{

	
	String cellData;
	
	public ArrayList<String> readExcelData(String data) {
		//data=excelPath,0,uat;
		
		ArrayList<String> loginInfo=new ArrayList<String>();
		
		int counter=0;
	
	try {
		
		String values []=data.split(",");//excelPath 0 3 1
		
		/*
		 * values[0]=excelPath
		 * values[1]=0
		 * values[2]=uat
		 */
		
		String path=values[0];//excelpath
		
		String serverName=values[2];
		
		int sheetNumber=Integer.valueOf(values[1]);//first sheet index
		
		File file=new File(path);
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(sheetNumber);//first sheet from excel 
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			
			XSSFRow row=sheet.getRow(i);
			
			XSSFCell cell=row.getCell(0);//cell
			
			cellData=cell.getStringCellValue();//INT, UAT
			//i=3, callData=UAT
			if(cellData.equalsIgnoreCase(serverName)) {
				
				String url=row.getCell(1).getStringCellValue();
				
				String userID=row.getCell(2).getStringCellValue();
				
				String password=row.getCell(3).getStringCellValue();
				
				loginInfo.add(url);
				loginInfo.add(userID);
				loginInfo.add(password);
				counter++;//1
				break;
			}	
		}
		
		wb.close();
		
	}catch(IOException io) {
		
		io.printStackTrace();
	}
	
	if(counter==0) {
		System.out.println("ERROR: Incorrect Server Name...Please check again");
	}
	return loginInfo;
	
	
	}
	
	
	public static void main(String [] args) {
		
		ReadExcel3 rb=new ReadExcel3();
		String excelPath="C:\\Users\\pandi.AJVIVOBOOK\\Downloads\\ReadExcelData.xlsx";
		ArrayList<String> value=rb.readExcelData(excelPath+",0,testing");//"excelPath,0,uat"
		
		System.out.println("Data we got from the Excel is ===>" +value);
		
		
		/*
		 * System.out.println("URL = " +value.get(0)); System.out.println("UserID = "
		 * +value.get(1)); System.out.println("Password = " +value.get(2));
		 */
	}

}


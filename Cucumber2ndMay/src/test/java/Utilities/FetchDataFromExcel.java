package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import ConstantData.ConstantsData;

public class FetchDataFromExcel {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	FetchDataFromExcel(String excelPath,String sheetName) throws IOException
	{
		 workbook=new XSSFWorkbook(ConstantsData.EXCEL_PATH);
	     sheet=workbook.getSheet(ConstantsData.SHEET_NAME);
	}
	
	
	
	
	
	
	@Test
	
	public static Object getDataExcel(int x,int y) throws IOException
	{
		
	    DataFormatter obj=new DataFormatter();
	  Object value=  obj.formatCellValue(sheet.getRow(x).getCell(y));
	  return value;
		
	}
	
	

}

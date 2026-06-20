package Utilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import ConstantData.ConstantsData;


public class GetExcelValue {
	
     public static Map getExcelValue() throws IOException
     {
    	 
    	 FetchDataFromExcel obj=new FetchDataFromExcel(ConstantsData.EXCEL_PATH,ConstantsData.SHEET_NAME);
    	 Map<String,Object> mp=new LinkedHashMap<String,Object>();
    	 mp.put("name",FetchDataFromExcel.getDataExcel(1, 0) );
    	 mp.put("gender", FetchDataFromExcel.getDataExcel(1, 1));
    	 mp.put("email", CommonFunctions.getEmailValue());
    	 mp.put("status", FetchDataFromExcel.getDataExcel(1, 2));
    	 return mp;
    	 
     }
	
	

}

package EmployeePOJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeePOJO {

	public static String EmployeeData() throws JsonProcessingException
	{
		CreateEmployee emp=new CreateEmployee();
		emp.setId(1234);
		emp.setAddress("New York");
		emp.setName("Harry");
		
		
		ObjectMapper obj=new ObjectMapper();
	String empJSON=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		return empJSON;
	
	
	
		
		
	}
	
	
}

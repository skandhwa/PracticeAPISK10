package Utilities;

public class CommonFunctions {
	
	
	public static String getEmailValue()
	{
		String email = "user" + java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 8) + "@gmail.com";
		return email;
	}

}

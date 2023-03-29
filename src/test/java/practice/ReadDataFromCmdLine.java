package practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	
	@Test
	public void readDataFromCmd()
	{
		String BROWSER=System.getProperty("chrome");
		System.out.println(BROWSER);
		
		String URL=System.getProperty("url");
		System.out.println(URL);
		
		String USERNAME=System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD=System.getProperty("password");
		System.out.println(PASSWORD);
		
		
	}

}

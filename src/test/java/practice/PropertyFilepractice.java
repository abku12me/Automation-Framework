package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilepractice {
	@Test
	public String datafrompropertiesfile(String key) throws IOException
	{
		//step 1:open the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		// step 2: create object of properties from java.util.package
		Properties pobj=new Properties();
		
		// step 3: load the properties object
		pobj.load(fis);
		
		// step 4; access the value with key
		String value=pobj.getProperty(key);
		return value;
		
		//System.out.println(URL);
		//String USERNAME=pobj.getProperty("username");
		//System.out.println(USERNAME);
		
		
		
	}

}

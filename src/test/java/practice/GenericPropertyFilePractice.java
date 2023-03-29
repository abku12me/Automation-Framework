package practice;

import java.io.IOException;

import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericPropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
	PropertyFileUtility pfu=new PropertyFileUtility();
  String URL=pfu.readDataFromPropertyFile("url");
  System.out.println(URL);
  
	}

}

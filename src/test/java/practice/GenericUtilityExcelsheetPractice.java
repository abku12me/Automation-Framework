package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;

public class GenericUtilityExcelsheetPractice {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility jutil=new JavaUtility();
		
		ExcelFileUtility efu=new ExcelFileUtility();
		String data=efu.readDataFromExcelsheet("Contacts",1,1 );
		System.out.println(data);
		System.out.println(efu.getLastRow("Contacts"));
		efu.writeDataInExcel("Contacts", 3, 4, "admin");
		System.out.println("data added");
		//date by DATE class
		System.out.println(jutil.getSystemDate());
		
		//date thru calendar class
		System.out.println(jutil.calendarFormatHandle(0));
		
		
		
	}

}

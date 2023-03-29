package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WritedataInexcelsheet {
	@Test
	public void writedata() throws EncryptedDocumentException, IOException
	{
		//step 1: create the java readable file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		//step 2: create the workbook
		Workbook book=WorkbookFactory.create(fis);
		
		//step 3: get the sheet
		Sheet sh=book.getSheet("Contacts");
		
		//step 4: create the row and column
		sh.createRow(4).createCell(5).setCellValue("Mindtree");
		
		
		//step 5: write in the excel sheet
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		book.write(fos);
		
		// step 6: complusory method
		fos.flush();
		System.out.println("data added");
		
		// close the workbook
		book.close();
		
	}
	

}

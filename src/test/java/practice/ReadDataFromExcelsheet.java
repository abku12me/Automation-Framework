package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelsheet {
	
	@Test
	public String datafromexcelsheet(String sheetname,int row1,int cell1) throws EncryptedDocumentException, IOException
	{
		//step1: create the java readable file
		FileInputStream fil=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		//step 2: create a workbook
		Workbook book=WorkbookFactory.create(fil);
		
		//step 3: get the sheet
		Sheet sh=book.getSheet(sheetname);
		
		//step 4:get the data in the form of string
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(row1).getCell(cell1));
		return value;
		
		
		
	}
	

}

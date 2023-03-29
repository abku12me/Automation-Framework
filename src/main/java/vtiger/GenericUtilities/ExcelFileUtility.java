package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
// single line comment
/* Multi line comment*/
/**
 * This class consist of generic method to read the data from excel sheet
 * @author mishr
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet based on row and column
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelsheet(String sheetname,int rownum,int cellnum ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.Execlpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return value;
		
	}
	
	public int getLastRow(String sheetname) throws EncryptedDocumentException, IOException
	{
		/**
		 * This method will get the row number utilized
		 */
		
		
		FileInputStream fis=new FileInputStream(IConstantUtility.Execlpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int rownum=sh.getLastRowNum();
		return rownum;
		
	}
	
	public void writeDataInExcel(String sheetname,int rownum,int cellnum,String value ) throws EncryptedDocumentException, IOException
	{
		/**
		 * This method will write the data into the excel sheet
		 */
		
		
		FileInputStream fis=new FileInputStream(IConstantUtility.Execlpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		sh.createRow(rownum).createCell(cellnum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IConstantUtility.Execlpath);
		wb.write(fos);
		
	}
	
	/**
	 * This method will get the last row number
	 * @param sheetname
	 * @param rownums
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void getLastCell(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.Execlpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		System.out.println(lastrow);
		
	}
	
	/**
	 * This method will load the data from excel sheet data provider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.Execlpath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		return data;
	}
	
	

}

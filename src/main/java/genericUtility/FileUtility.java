
package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of all generic methods related to file operations
 *@author kavya v
 */
public class FileUtility {
/**
 * this method will read datafrom property file and return the value to caller
 * @throws IOException 
 * @return value
 * @param kay
 * 
 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		}
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		
		
	public String readDataFromExcelFile(String sheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int readDataFromExcelFile1(String sheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Object value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getNumericCellValue();
		return (int) value;
	}
	
	
	
	
	
	
	
	
	
	
	
}

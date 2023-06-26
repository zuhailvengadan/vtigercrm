package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import genericLibraries.IAutoConstants;

public class ReadMultipleDataFromExcel {
	
	Workbook workbook;
	public Object[][] readingmultipleData() throws InvalidFormatException, FileNotFoundException  {
		FileInputStream file = new FileInputStream(IAutoConstants.EXCELPATH);
		
		try {
			workbook=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet= workbook.getSheet("sheet1");
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount][cellCount];
		for (int row = 0; row < rowCount; row++) {
			Row actualRow =sheet.getRow(row);
			for (int cell = 0; cell < actualRow.getLastCellNum(); cell++) {
	
	
				data[row][cell]=actualRow.getCell(cell).toString();
			}
		}
		return data;
		}
	@DataProvider(name="testdata")
	public static void main(String[] args ) throws InvalidFormatException, FileNotFoundException  {
		ReadMultipleDataFromExcel d=new ReadMultipleDataFromExcel();
		Object[][] obj=d.readingmultipleData();
	
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j < obj[i].length; j++) {

				System.out.println(obj[i][j]);
			}
			
		}
	}
}


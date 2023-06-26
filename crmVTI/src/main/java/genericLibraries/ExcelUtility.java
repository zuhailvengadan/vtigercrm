package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends BaseClass {

	public String ReadingSingleData(String sheetName, int rowNum, int columnNumber)throws EncryptedDocumentException, IOException, InvalidFormatException {
		File file = new File(IAutoConstants.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);

		DataFormatter df = new DataFormatter();

		return df.formatCellValue( workbook.getSheet("sheetNo").getRow(rowNum).getCell(columnNumber));

	}
	

	public class ReadMultipleDataFromExcel {
		public Object[][] readingmultipleData() throws EncryptedDocumentException, IOException, InvalidFormatException {
			File file=new File(IAutoConstants.EXCELPATH);
			Workbook workbook=WorkbookFactory.create(file);
			Sheet sheet= workbook.getSheet("sheet1");
			int rowCount=sheet.getPhysicalNumberOfRows();
			int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
			Object[][] data = new Object[rowCount][cellCount];
			for (int row = 0; row < rowCount; row++) {
				Row actualRow =sheet.getRow(row);
				for (int cell = 0; cell < actualRow.getLastCellNum(); cell++) {
					DataFormatter df = new DataFormatter();
		
					data[row][cell]=df.formatCellValue(actualRow.getCell(cell));
				}
			}
			return data;
}}
}
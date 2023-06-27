package practise;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibraries.IAutoConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class p {

	@Test(dataProvider ="t" )
	public void a() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys("url");
	}
	@DataProvider(name="t")
	public Object[][] Excel() {
		File file=new File(IAutoConstants.EXCELPATH);
		Workbook work=null;
		try {
			 work=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet=work.getSheet("sheet1");
		int RowCount=sheet.getPhysicalNumberOfRows();
		int CellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[RowCount][CellCount];
		for (int row = 0; row < RowCount; row++) {
			Row actualRow =sheet.getRow(row);
			for (int cell = 0; cell < actualRow.getLastCellNum(); cell++) {
	
	
				data[row][cell]=actualRow.getCell(cell).toString();
			}
		}
		return data;
		}
		
	}

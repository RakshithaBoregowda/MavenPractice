package practice1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.tyss.rmb.genericUtility.JavaUtility;


public class GenMeth 
{
	WebDriver driver;
	Workbook workbook;
	
	
public void selectByval(WebElement element, String val )
{
	Select s=new Select(element);
	s.selectByValue(val);
}

public void selectByIndex(WebElement element, int index)
{
	Select s=new Select(element);
	s.selectByIndex(1);
}

public void selByVisible(WebElement element, String text)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
/**
 * This method is used to capture the screenshot in report using base64
 * @return
 */
public String ScreenShot(WebDriver Driver)
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	String tempPath= ts.getScreenshotAs(OutputType.BASE64);
	return tempPath;
}

public void screenShot(WebDriver driver, JavaUtility javaUtility, String className) throws IOException 
{
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dst=new File("./screenshot/"+className+".png");
	 FileUtils.copyDirectory(src, dst);
	 
	 
}

public void actions()
{

Actions act=new Actions(driver);
act.click();
}
/**
 * This method is used to open the excel
 * @param path
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public void openExcel(String path) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(path);
	workbook= WorkbookFactory.create(fis);
}

public Map<String, String> FetchDataFromMap(String sheetName)
{
Sheet sheet = workbook.getSheet(sheetName);

//object maps key to value 
//HashMap class implements the map interface which allows to store key and value pair 
Map<String, String> map =new HashMap<>();

DataFormatter dataFormatter=new DataFormatter();
for(int i=0;i<sheet.getLastRowNum();i++)
{
	map.put(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)),
			dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)));
}
	return map;
	
	
}
}

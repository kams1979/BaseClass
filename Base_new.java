package base.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_new {
	
 public static WebDriver driver;
	
	public static WebDriver BrowserLaunch() {
		
	       driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       return driver;
	       
		}
	
	public static void Url(String url) {
		driver.get(url);
    
	}

	public static void SendKeys(WebElement send ,String s) {
		send.sendKeys(s);
       
	}
	
	public static void click1(WebElement click) {
		click.click();
	}
	
	public static void Quit() {
	      
	}
	
	public static void Selectby_Index(WebElement d,int string) {
	       Select s1=new Select(d);
	       s1.selectByIndex(string);
		}
	public static void Selectby_value(WebElement e,String j) {
		Select s2=new Select(e);
	       s2.selectByValue(j);
	}
	
	public static void Selectby_visisbleText(WebElement f,String k) {
		Select s3=new Select(f);
		s3.selectByVisibleText(k);
	}
	public static void Screenshot(String ss) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;//driver class variable
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Kavin\\eclipse-workspace\\ScreenShotDemo\\amazon\\"+ss+".png");
        FileUtils.copyFile(screenshotAs, f);		
	}
	
	public static void Action() {
		Actions ac=new Actions(driver);
		WebElement s = driver.findElement(By.id("angular"));
		ac.build().perform();
	}
	
	public static void Robot1() throws AWTException {
		Robot r= new Robot();  //AWT is abstract window tool kit
	      r.keyPress(KeyEvent.VK_DOWN);
	       r.keyRelease(KeyEvent.VK_DOWN);
	       r.keyPress(KeyEvent.VK_ENTER);
	       r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void Alert1() {
		 Alert alert = driver.switchTo().alert();
	     alert.accept();
	}
	
	public static void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	public static String values;
	
	public static String Read_data(int r, int c) throws Throwable  {
		// TODO Auto-generated method stub
     
		
		File f=new File("C:\\Users\\Kavin\\eclipse-workspace\\Maven_11\\Data2.xlsx ") ;
		  
		  FileInputStream fi = new  FileInputStream(f);
		  
		  Workbook w =new XSSFWorkbook(fi);
		  
		  Sheet sheetAt = w.getSheetAt(0);
		  
		  Row row = sheetAt.getRow(r);
		  
		  Cell cell = row.getCell(c);
		  
		  CellType cellType = cell.getCellType();
		  
		  
		  if (cellType.equals(cellType.STRING)) {
			  
			//System.out.println(cell.getStringCellValue());
			
			values = cell.getStringCellValue();
			  
		} else if (cellType.equals(cellType.NUMERIC)) {
			
			//System.out.println((cell.getNumericCellValue()));
			double numericCellValue = cell.getNumericCellValue();

			int value1 = (int)numericCellValue;
			//System.out.println(value);
			values = String.valueOf(value1);
			
			
		}
		  
		  
		  return values;
		  
	}
	}
	
	


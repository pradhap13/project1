package org.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	

	   public static WebDriver driver;
	   public static WebDriver chromedriver() {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 return driver;
	}
	   //2url launch
	   public static void urlLaunch(String url) {
		 driver.get(url);
		driver.manage().window().maximize();
	}
	   //3wait
	   public static void implicitlywait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);	
	}
	   //4 sendkeys
	   public static void sendkeys(WebElement e, String a) {
		   e.sendKeys(a);
	}
	   //5 click
	   public static void click(WebElement e) {
		   e.click();
	} 
	   //
	    public static String title() {
			String tlt= driver.getTitle();
			return tlt;
	}		
		//6 find element	
		 public static WebElement FindElement(String In,String Iv) {
			WebElement value= null;
			if(In.equals("id")) {
				value=driver.findElement(By.id(Iv));
	        }
			else if (In.equals("name")) {
			value=driver.findElement(By.name(Iv));
			}
			else if (In.equals("xpath")) {
				value=driver.findElement(By.xpath(Iv));
			}
			return value;	
	}	
		//7 Get title	
			public static String getTitle() {
				String title=driver.getTitle();
				return title;
			}
		//8 getcurrent url
			public static String getCurrentUrl() {
				String currentUrl = driver.getCurrentUrl();
				return currentUrl;
				}
		//9 close 
			public static void close() {
			  driver.close();
			  }
		//10 Quit
			public static void quit() {
				driver.quit();
				}
		//11 get text
			public static String getText(WebElement gt) {
				String text = gt.getText();
				return text;
			}
		//12 get Attribute
			public static String getAttribute(WebElement ga) {
				String attribute = ga.getAttribute("value");
				return attribute;
				}
		//13 Action
		// MoveToElement
			public static void moveToElement(WebElement mte) {
				Actions a=new Actions(driver);
				a.moveToElement(mte).perform();
			}
	    //14 drag and drop
			public static void dragAndDrop(WebElement src,WebElement des) {
				Actions a=new Actions(driver);
	            a.dragAndDrop(src, des).perform();
			}
		//15 double click
			public static void doubleClick(WebElement dc) {
				Actions a=new Actions(driver);
	          a.doubleClick().perform();
			}
	    //16 context click
			 public static void contextClick(WebElement ct) {
				 Actions a=new Actions(driver);
	           a.contextClick().perform();
			}
		//17 select
			// select by Index
			public static void selectByIndex(WebElement sbi,int index) {
				Select s=new Select(sbi);
	           s.selectByIndex(index);
			}
		// 18 selectByValue	
			public static void selectByValue(WebElement sbv,String value) {
				Select s=new Select(sbv);
	            s.selectByValue(value);
			}
		//19 selectByvisible
			public static void selectByVisible(WebElement sbv, String text) {
				Select s=new Select(sbv);
				s.selectByVisibleText(text);
			}
		//20 getFirst Selected option
			public static void getFirstSelectetOption(WebElement gfs) {
				Select s=new Select(gfs);
				s.getFirstSelectedOption();
			}
		//21 Refresh
			public static void refresh() {
				driver.navigate().refresh();
			}
		//22 isMultiple
			public static boolean isMultiple(WebElement e) {
				Select s=new Select(e);
	            boolean multiple = s.isMultiple();
				return multiple;
			}
		//23 deSelectByIndex
			public static void deSelectByIndex(WebElement ds,int index) {
				Select s=new Select(ds);
	            s.deselectByIndex(index);
			}
		//24 deSelectByValue
			public static void deSelectByValue(WebElement dv,String Value) {
				Select s=new Select(dv);
			    s.deselectByValue(Value);
			}
		//25 deSelectByVisibleText
			public static void deSelectByVisible(WebElement i,String Value) {
				Select s=new Select(i);
			    s.deselectByVisibleText(Value);	
			}
		//26 Get Options
			public static String getOption(WebElement op,int index) {
				Select s=new Select(op);
				List<WebElement> options = s.getOptions();
				WebElement we= options.get(index);				
				String text = we.getText();
				return text;
			}
        //27 deSelectAll
			public static void deSelectAll(WebElement dsa,int index) {
				Select s=new Select(dsa);
                List<WebElement> o = s.getOptions();
                for(int i=0;i<o.size();i++) {
                	s.selectByIndex(i);
                }
                s.deselectAll();
			}
        //28 isDisplayed
			public static boolean isDisplayed(WebElement id) {
				boolean displayed = id.isDisplayed();
				return displayed;
				}
		//29 isSelected
			public static boolean isSelected(WebElement is) {
				boolean selected = is.isSelected();
				return selected;	
			}
		//30 isEnabled
			public static boolean isEnabled(WebElement ie) {
				boolean enabled = ie.isEnabled();
				return enabled;
			}
		//Excel Read
			public static String exceldate(String excelName,String sheetName,int rowNo,int cellNo) throws IOException {
			File c=new File("C:\\\\Users\\\\LENOVO\\\\eclipse-workspace\\\\Mavenn\\\\src\\\\test\\\\resources\\\\Datas.xlsx");
            FileInputStream fs=new FileInputStream(c);
            Workbook wb=new XSSFWorkbook(fs);
            Sheet s=wb.getSheet(sheetName);
            Row r=s.getRow(rowNo);
            Cell c1=r.getCell(cellNo);
            
            int cell = c1.getCellType();
            String value=null;
            if(cell==1) {
               value = c1.getStringCellValue();
             }
            else {
            	if(DateUtil.isCellDateFormatted(c1)) {
            		value = new SimpleDateFormat("dd-mm-yyyy").format(c1.getDateCellValue());
            	}
            	else {
            		value =String.valueOf((long) c1.getNumericCellValue());
            	}
            }
            	return value;
            	
           	
            	
            	
            	
            	
            	
            }
			}

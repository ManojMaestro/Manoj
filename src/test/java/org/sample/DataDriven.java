package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	public static WebDriver driver;
	public static void launchChrome() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	public static void winMax() {
	driver.manage().window().maximize();
	}
	
	public static void launchUrl(String Url) {
	driver.get(Url);
	}
	 public static String getData(int row, int cell) throws IOException {
	
		 File f = new File("C:\\Users\\User\\eclipse-workspace\\Framework\\src\\test\\resources\\TestData\\DDExcel.xlsx");

		 FileInputStream fin = new FileInputStream(f);
		 
		 Workbook w = new XSSFWorkbook(fin);
	
		 Sheet s = w.getSheet("ebay");
		 
		 Row row2 = s.getRow(row);
		 
		 Cell cell2 = row2.getCell(cell);
	 
		 int cellType = cell2.getCellType();
		 
		 String Value="";
		 if (cellType==1) {
		Value = cell2.getStringCellValue();
		}
		 else if (DateUtil.isCellDateFormatted(cell2)) {
			Date dateCellValue = cell2.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd MMM yyyy");
			Value = sim.format(dateCellValue);
		} else {
			double n = cell2.getNumericCellValue();
			
			long l = (long)n;
			
			 Value = String.valueOf(l);
		}
		 
		 return Value;
	 }
		public static void fill(WebElement ele, String Value) {
		ele.sendKeys(Value);
		}
		public static void btnClick(WebElement ele) {
		ele.click();

		}
		
}

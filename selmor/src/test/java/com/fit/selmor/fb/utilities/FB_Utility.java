package com.fit.selmor.fb.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fit.selmor.fb.testdata.FB_TestData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_Utility {
	static WebDriver driver = null;
	static WebDriverWait wait =null;
	public static WebDriver getDriver(String browser_type) {
		
		if(browser_type.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser_type.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return driver;
		
	}
	
	public static void load_website(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	
	}
	
	
	public static void tear_down() {
		driver.quit();
	}
	
	public static WebElement get_element(String locator) {
		String[] loc_type = locator.split("_");
		WebElement element = null;
		if(loc_type[0].equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.
					presenceOfElementLocated(By.name(loc_type[1])));
			element = driver.findElement(By.name(loc_type[1]));

		}
		else if(loc_type[0].equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.
					presenceOfElementLocated(By.xpath(loc_type[1])));
			element = driver.findElement(By.xpath(loc_type[1]));
		}
		else if(loc_type[0].equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.
					presenceOfElementLocated(By.id(loc_type[1])));
			element = driver.findElement(By.id(loc_type[1]));

		}
		else if(loc_type[0].equalsIgnoreCase("linktext")) {
			wait.until(ExpectedConditions.
					presenceOfElementLocated(By.linkText(loc_type[1])));
			element = driver.findElement(By.linkText(loc_type[1]));

		}
		
		else if(loc_type[0].equalsIgnoreCase("class")) {
			wait.until(ExpectedConditions.
					presenceOfElementLocated(By.className(loc_type[1])));
			element = driver.findElement(By.className(loc_type[1]));

		}
		return element;
	}
	
	public static void getScreenshot() throws IOException {
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String now = sd.format(d);
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(FB_TestData.SCREEN_PATH+"screenshot"+now+".png");
        FileUtils.copyFile(SrcFile, DestFile);



	}
	
}

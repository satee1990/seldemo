package com.fit.selmor;

import java.time.Duration;
import java.util.*;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Test2 {
	
	WebDriver driver = null;
	
    private static final Logger Log =  LoggerFactory.getLogger(Test2.class);

	
	@Test
	@Parameters({"browser"})
	public void google(String browser) {
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Log.info("Edge driver created");
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Log.info("chrome driver created");

		}
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Log.info("google opned ");
		System.out.println(driver.getTitle());
		driver.close();
		Log.info("browser closed");

	}

	
	
	
	
	
	
	
	

}

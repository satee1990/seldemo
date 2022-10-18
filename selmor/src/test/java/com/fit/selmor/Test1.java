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

public class Test1 {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void open_browser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void fb() {
	
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=0)
	public void redbus() {
	
		driver.get("http://www.redbus.in");
		System.out.println(driver.getTitle());
	}
	@Test(priority=1)
	public void gmail() {
	
		driver.get("http://www.gmail.com");
		System.out.println(driver.getTitle());
	}
	
	
	
	@AfterTest
	public void close_browser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	
	
	

}

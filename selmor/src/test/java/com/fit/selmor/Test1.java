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
	
	
	
	@DataProvider (name = "logindata")
    public Object[][] logindata(){
//	 return new Object[][] {{"xyz@gmail.com","password1"}, 
//		 {"abc@gmail.com","passwowrd2"}};
		ExcelUtility utility = new ExcelUtility();
		Object[][] data = utility.getLoginData();
		return data;
    }
	
	@Test(dataProvider = "logindata")
	public void fb(String email,String pass) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("pass")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	

}

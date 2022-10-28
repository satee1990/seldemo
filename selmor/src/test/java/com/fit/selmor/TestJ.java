package com.fit.selmor;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJ {
	@Test
	public void verify() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		WebElement cust_table = driver.findElement(By.id("customers"));
		List<WebElement> trs = cust_table.findElements(By.tagName("tr"));
		
		List<WebElement> ths = trs.get(0).findElements(By.tagName("th"));
		for(WebElement th:ths) {
			System.out.print(th.getText()+"\t");
		}
		System.out.println();
		int i;
		for(i=1;i<trs.size();i++) {
			WebElement tr = trs.get(i);
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			for(WebElement td:tds) {
				System.out.print(td.getText()+"\t");
			}
			System.out.println();

			
		}
		
		
		
		Thread.sleep(3000);
		driver.close();
	}
}

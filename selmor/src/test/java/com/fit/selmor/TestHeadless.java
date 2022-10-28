package com.fit.selmor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;


public class TestHeadless {

	@Test
	public void f1() throws InterruptedException {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}
}

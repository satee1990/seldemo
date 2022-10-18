package com.fit.selmor.fb.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.fit.selmor.fb.pom.FB_POM;
import com.fit.selmor.fb.testdata.FB_TestData;
import com.fit.selmor.fb.utilities.FB_Utility;

public class FB_TC {
	
	FB_POM fb_pom = new FB_POM();

	@Test
	public void fb_login() {
		
		FB_Utility.getDriver("chrome");
		FB_Utility.load_website(FB_TestData.URL);
		fb_pom.login_verify();
		FB_Utility.tear_down();
		
	}

}

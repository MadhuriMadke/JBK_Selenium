package com.tka.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tka.utilities.SeleniumUtilities;

public class LOginDataDP {
	@Test(dataProvider = "LoginCredentials")
	  public  static void LoginCheck(String username, String password) {
		  WebDriver driver = SeleniumUtilities.openBrowser();
			SeleniumUtilities.OpenANyUrl(driver, "https://javabykiran.com/liveproject/pages/examples/logout.html");
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
			String ActResult = driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[7]/a/span")).getText();
			String ExpResult = "Logout";
			Assert.assertEquals(ActResult, ExpResult);
			driver.quit();
	  }

	  @DataProvider
	  public Object[][] LoginCredentials() {
	    return new Object[][] {
	      new Object[] { "kiran@gmail.com", "123456" },
	      new Object[] {"kiran123@gmail.com", "password123" },
	      new Object[] {"jbk@gmail.com", "pass123456" },
	      new Object[] {"2132jbk", "@657*" },
	      new Object[] {"$#@>", "123456" },
	    };
	  }

}

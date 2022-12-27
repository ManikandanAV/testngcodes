package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	RemoteWebDriver driver;
	@Parameters({"browser","user","password"})
	@Test
	public void logIn(String browser,String user,String password) {
		
	if(browser.equals("chrome")) {
		
		driver = new ChromeDriver();
	}
	else if(browser.equals("edge")){
		
		driver = new EdgeDriver();
	}
			
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys(user);
	driver.findElement(By.id("pass")).sendKeys(password);
	driver.findElement(By.name("login")).click();
		
		
		
	}

}

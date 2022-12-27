package org.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingExcelDatas {
	@Test(dataProvider = "loginDatas",
			dataProviderClass = DataproviderWithExcel.class)
	public void dataUtils(String data[]) {
		System.out.println(data[0]);
		System.out.println(data[1]);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(data[0]);
		driver.findElement(By.id("pass")).sendKeys(data[1]);
		driver.findElement(By.name("login")).click();
		
		
	}

}

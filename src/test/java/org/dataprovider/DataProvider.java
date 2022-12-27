package org.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider {
	@org.testng.annotations.DataProvider( parallel = !true)
	public String[][] loginDatas() {

		String[][] data = new String[2][2];
		data[0][0] = "mani@gmail.com";
		data[0][1] = "12345";
		data[1][0] = "mani123@gmail.com";
		data[1][1] = "458796";
		return data;

	}

	@Test(dataProvider = "loginDatas")
	public void logIn(String user, String password) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();

	}


}

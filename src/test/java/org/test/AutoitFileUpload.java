package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoitFileUpload {

	@Test
	public void runWithTestng() throws Throwable {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/upload");

		driver.manage().window().maximize();

		WebElement choosefile = driver.findElement(By.id("file-upload"));

		Actions action = new Actions(driver);
		action.moveToElement(choosefile).click().perform();

//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click", choosefile);
		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\mania\\OneDrive\\Documents\\uploadusingautoit.exe");

	}

}

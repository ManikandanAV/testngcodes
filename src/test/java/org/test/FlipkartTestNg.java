package org.test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTestNg {

	static WebDriver driver;

	@Test(priority = 1/* , invocationCount = 2 */)
	public static void lanchUrl() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https:/www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@Test(dependsOnMethods = "lanchUrl")
	public void logIn() {

		WebElement user = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		user.sendKeys("mani@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		pass.sendKeys("123455");
		WebElement login = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		// login.click();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}

	@Test(priority = 3)
	public void searching() {

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("iphones13", Keys.ENTER);

	}

	@Test(priority = 4)
	public void iPhone13Red() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement scroll = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[5]"));

		JavascriptExecutor jscript = (JavascriptExecutor) driver;
		jscript.executeScript("arguments[0].scrollIntoView(true)", scroll);

		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[6]")).click();

	}

	@Test(priority = 5)
	public void windowHandling() {

		String parent = driver.getWindowHandle();
		Set<String> childs = driver.getWindowHandles();
		for (String x : childs) {
			if (!parent.equals(x)) {
				driver.switchTo().window(x);
			}
		}

	}

	@Test(priority = 6)
	public void addToCart() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement addtocart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));

		Actions mouse = new Actions(driver);
		mouse.moveToElement(addtocart).click().perform();

	}

	@Test(priority = 7, enabled = false)
	public void browserClosing() {
		driver.quit();
	}

}

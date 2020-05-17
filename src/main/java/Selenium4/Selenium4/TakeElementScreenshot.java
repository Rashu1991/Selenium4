package Selenium4.Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeElementScreenshot {

	public static void main(String []args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://app.hubspot.com/login");
		WebElement email=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement loginBtn=driver.findElement(By.id("loginBtn"));
		
		email.sendKeys("naveen@gmail.com");
		password.sendKeys("Test@123");
		
		takeScreenshot(email, "emailElement");
		takeScreenshot(password, "passwordElement");
		takeScreenshot(loginBtn, "loginBtn");
		
		driver.quit();
		
	}
	
	public static void takeScreenshot(WebElement ele, String fileName) {
		File srcFile=ele.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshots/"+fileName+" .png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

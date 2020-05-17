package Selenium4.Selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MinimizeExample {
	
	@Test
	public void doActions() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().minimize();
		driver.get("https://www.google.co.in");
		WebElement srch=driver.findElement(By.name("q"));
		srch.sendKeys("A");
		srch.clear();
		srch.sendKeys("B");
		srch.clear();
		srch.sendKeys("C");
		srch.clear();
		srch.sendKeys("D");
		srch.clear();
		
		driver.navigate().refresh();
		srch.sendKeys("E");
		srch.clear();
		
		File srcFile=srch.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./target/screenshots/"+System.currentTimeMillis()+".png"));
		
		
		driver.close();
		
		
	}

}

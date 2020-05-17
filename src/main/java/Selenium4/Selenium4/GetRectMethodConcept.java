package Selenium4.Selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRectMethodConcept {

	public static void main(String []args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://app.hubspot.com/login");
		
		WebElement loginBtn=driver.findElement(By.id("loginBtn"));	
		
		// selenium - 3
		Dimension loginBtnDim=loginBtn.getSize();
		System.out.println(loginBtn.getSize().getHeight());
		System.out.println(loginBtnDim.getHeight());
		System.out.println(loginBtnDim.getWidth());
		
		Point p=loginBtn.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		
		// selenium -4
		Rectangle loginBtnRect=loginBtn.getRect();
		System.out.println(loginBtnRect.getHeight());
		System.out.println(loginBtnRect.getWidth());
		
		System.out.println(loginBtnRect.getX());
		System.out.println(loginBtnRect.getY());
		
		

		
	}
}

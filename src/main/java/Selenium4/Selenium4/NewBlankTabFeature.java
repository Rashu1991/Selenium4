package Selenium4.Selenium4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBlankTabFeature {

	public static void main(String []args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		System.out.println("Before Switch to new TAB "+driver.getTitle());
		
		//driver.switchTo().newWindow(WindowType.TAB); // open a new tab
		driver.switchTo().newWindow(WindowType.WINDOW); // open a new window
		
		System.out.println("After switch to new TAB "+driver.getTitle());
		
		
		Set<String> handles=driver.getWindowHandles();
		
		List<String> ls = new ArrayList<String>(handles);
		
		String parentWindow=ls.get(0);
		String childWindow = ls.get(1);
		
		System.out.println("Parent Window "+parentWindow);
		System.out.println("Child Window "+childWindow);
		
		driver.get("https://www.facebook.com");
		System.out.println("After switch to new TAB "+driver.getTitle());
		
		driver.close();
		driver.switchTo().window(parentWindow);
		
		System.out.println(driver.getTitle());
		driver.quit();
	}
}

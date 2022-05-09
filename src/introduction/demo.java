package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//invoke .exe browser file, should be same version with web browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		
		//driver object chrome
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		
		//get webpage title
		//System.out.println("webpage title: " + driver.getTitle());
		
		//get webpage address
		//System.out.println(driver.getCurrentUrl());
		
		//get page source
		//System.out.println(driver.getPageSource());
		
		//driver.get("https://www.yahoo.com");
		//webpage navigation
		//driver.navigate().back();
		//driver.navigate().forward();
		
		//close current browser
		//driver.close();
		
		//close all browser opened by selenium
		//driver.quit();
		
		driver.get("https://www.facebook.com");
		System.out.println("webpage title: " + driver.getTitle());		
		//locator id, name, classname, linktext - not reliable
		//driver.findElement(By.id("email")).sendKeys("hello");
		//driver.findElement(By.name("pass")).sendKeys("123");
		//driver.findElement(By.linkText("Nakalimutan ang Password?")).click();
		
		//driver.close();
	}

}

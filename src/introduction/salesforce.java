package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		
		//driver object chrome
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		System.out.println("webpage title: " + driver.getTitle());	
		driver.findElement(By.id("username")).sendKeys("hello");
		//driver.findElement(By.name("pw")).sendKeys("123");
		driver.findElement(By.cssSelector("#password")).sendKeys("123");
		//driver.findElement(By.className("button r4 wide primary")).click();
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		//get text error msg
		System.out.println(driver.findElement(By.xpath("//*[@id=\'error\']")).getText());
	}

}

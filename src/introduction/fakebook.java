package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fakebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
				
		//driver object chrome
		WebDriver driver = new ChromeDriver();
			
		driver.get("https://www.facebook.com");
		System.out.println("webpage title: " + driver.getTitle());
		
		//xpath regex - //tagname[contains(@attribute,'value')]
		//css regex - tagname[attribute*='value']
		
		//xpath-//tagname[@attribute='value']
		/*driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@name='login']")).click();*/
		
		//css-tagname[attribute='value'], tagname#id, tagname.classname
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("hello");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123");
		driver.findElement(By.cssSelector("button[name='login']")).click();
		
		//get text error msg
		//System.out.println(driver.findElement(By.xpath("//*[@id=\'error\']")).getText());
	}

}

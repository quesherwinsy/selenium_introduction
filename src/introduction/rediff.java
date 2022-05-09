package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		
		//driver object chrome
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com");
		System.out.println("webpage title: " + driver.getTitle());
		
		//xpath regex - //tagname[contains(@attribute,'value')]
		//css regex - tagname[attribute*='value']
		//xpath-//tagname[@attribute='value']
		//css-tagname[attribute='value'], tagname#id, tagname.classname
		
		driver.findElement(By.cssSelector("a[class*='signin']")).click();
		//get text error msg
		//System.out.println(driver.findElement(By.xpath("//*[@id=\'error\']")).getText());	

	}

}

package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class assignment_05 {
	
	@Test
	public void frame_test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
	}
}

package basic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class assignment_04 {

	@Test
	public void multiple_invoke() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[normalize-space()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

		Set<String> handleID = driver.getWindowHandles();
		Iterator<String> handleIT = handleID.iterator();
		String parentIT = handleIT.next();
		String childIT = handleIT.next();
		driver.switchTo().window(childIT);

		System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText());
		driver.switchTo().window(parentIT);
		System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText());

	}
}

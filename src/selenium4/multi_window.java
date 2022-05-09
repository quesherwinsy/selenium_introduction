package selenium4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class multi_window {

	@Test
	public void multiple_invoke() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		Thread.sleep(3000);

		// invoke open a new tab or window
		driver.switchTo().newWindow(WindowType.TAB);
		// driver.switchTo().newWindow(WindowType.WINDOW);
		// get all open window ID handles
		Set<String> handleID = driver.getWindowHandles();
		// set window IT handle as iterator parent and child
		Iterator<String> handleIT = handleID.iterator();
		String parentIT = handleIT.next();
		String childIT = handleIT.next();
		// switch control to new open child tab
		driver.switchTo().window(childIT);
		driver.get("https://www.rahulshettyacademy.com/");
		Thread.sleep(3000);
		// get text of the 1st course displayed
		String courseText = driver
				.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p/')]")).get(1)
				.getText();
		// switch back to parent tab
		driver.switchTo().window(parentIT);
		// input text of 1st course in name field
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(courseText);
	}
}

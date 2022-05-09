package selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class capture_screenshot {

	@Test
	public void capture_screen() throws InterruptedException, IOException {
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

		// place name filed in web element variable
		WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
		// input text of 1st course in name field
		nameField.sendKeys(courseText);
		// get screenshot of name field
		File fileSC = nameField.getScreenshotAs(OutputType.FILE);
		// copy screenshot file to destination file name and folder
		FileUtils.copyFile(fileSC, new File("logo_rahul.png"));
		
		// get dimension size of name field
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
	}
}

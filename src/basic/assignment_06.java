package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assignment_06 {
// https://rahulshettyacademy.com/AutomationPractice/
// select checkbox sample option 2 and copy text
// select dropdown box and select option based on copied text
// in alert text field, input copied text
// click alert button, check if copied text is in popup message

	@Test
	public void frame_test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		String selectedOp = driver.findElement(By.xpath("//label[@for='benz']")).getText();

		WebElement staticDD = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdown = new Select(staticDD);
		dropdown.selectByVisibleText(selectedOp);

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(selectedOp);
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		String alertMsg = driver.switchTo().alert().getText();
		if (alertMsg.contains(selectedOp)) {
			Assert.assertTrue(true);
		}
	}
}

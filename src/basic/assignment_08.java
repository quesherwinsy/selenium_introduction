package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assignment_08 {
//https://www.rahulshettyacademy.com/AutomationPractice/
//suggestion class sample input ind, select india
//verify text input is same with selected value india

	@Test
	public void autosuggest_test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		Thread.sleep(2000);
		String opText = null;

		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				opText = option.getText();
				break;
			}
		}

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='autocomplete']")).getText().toLowerCase(),
				opText.toLowerCase());
	}
}

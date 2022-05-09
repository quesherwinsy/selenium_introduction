package stream;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class stream_filter {

	@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(3000);

		// Find search text box and input item
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		// capture all web element in web table to list
		List<WebElement> item_collected = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		// get all the item names with filer and getText() from the result
		List<WebElement> item_filtered = item_collected.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		// check if result of search result and filtered result is same
		Assert.assertEquals(item_collected.size(), item_filtered.size());

	}
}

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

public class stream_table_sort {

	@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(3000);

		// click on column button
		driver.findElement(By.xpath("//th[contains(@aria-label,'Veg/fruit')]")).click();
		// capture all web element in web table to list
		List<WebElement> item_collected = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		// Collect all String of stream web element to new list
		List<String> item_original = item_collected.stream().map(s -> s.getText()).collect(Collectors.toList());
		// Collect and Sort the original list alphabetically to new list
		List<String> item_sorted = item_original.stream().sorted().collect(Collectors.toList());
		// compare original list vs new list
		Assert.assertTrue(item_original.equals(item_sorted));

		// question what if item is in different page? Use pagination concept
		List<String> item_price;
		do {
			List<WebElement> item_toFind = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			// scan name column with filter and getText() > search beans
			// get price of beans with getPriceItem()
			item_price = item_toFind.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceItem(s))
					.collect(Collectors.toList());
			item_price.forEach(a -> System.out.println("The price is " + a));

			// check if item and price if found
			if (item_price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (item_price.size() < 1);
		
		//"//input[@id='search-field']"

	}

	private static String getPriceItem(WebElement s) {
		// traverse sibling of web element parameter and get price
		String price_value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price_value;
	}
}

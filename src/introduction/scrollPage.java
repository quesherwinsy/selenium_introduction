package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrollPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object chrome
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("webpage title: " + driver.getTitle());

		// Java script executor, scroll page and specific page
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000L);
		jsx.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

		// Selenium traverse table get and compare value
		int summ = 0;
		List<WebElement> val = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for (int i = 0; i < val.size(); i++) {
			summ += Integer.parseInt(val.get(i).getText());
		}
		int expec = Integer
				.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(summ, expec);
	}

}

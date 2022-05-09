package introduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class greenkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object chrome
		WebDriver driver = new ChromeDriver();

		// driver implicit wait globally
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver explicit wait specific
		WebDriverWait xwait = new WebDriverWait(driver, 5);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		System.out.println("webpage title: " + driver.getTitle());

		String[] foodFind = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		addItems(driver, foodFind);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();

		// explicit wait for text field element
		xwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		// explicit wait for text element
		xwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
	}

	// Get web element, place into array, then select add to cart button
	public static void addItems(WebDriver driver, String[] foodFind) {
		int endo = 0;
		List<WebElement> foods = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < foods.size(); i++) {
			String[] foodName = foods.get(i).getText().split("-");
			String foodFormat = foodName[0].trim();
			List foodList = Arrays.asList(foodFind);
			if (foodList.contains(foodFormat)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				endo++;
				if (endo == foodFind.length) {
					break;
				}
			}
		}
	}

}

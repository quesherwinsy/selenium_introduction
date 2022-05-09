package functional_04;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class addToCart_item_01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();
		// implicit wait 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// maximize the window screen
		driver.manage().window().maximize();
		// webdriver go to URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// thread sleep
		Thread.sleep(3000);
		System.out.println("webpage title: " + driver.getTitle());

		String[] foodFind = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		// call method to find and add to cart specific food item
		addItems(driver, foodFind);
		
		// locate cart icon and click
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		// locate proceed to checkout button and click
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();

		// explicit wait for text field element
		/*
		xwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		// explicit wait for text element
		xwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		*/
	}

	// Get web element, place into array, then select add to cart button
	public static void addItems(WebDriver driver, String[] foodFind) throws InterruptedException {
		int endo = 0;
		// locate all product name and add to array list of web element
		List<WebElement> foods = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < foods.size(); i++) {
			// get specific product name by index and split text by "-" character
			String[] foodName = foods.get(i).getText().split("-");
			// get specific name and remove spaces and place to a string
			String foodFormat = foodName[0].trim();
			// place the food names to find inside the array list
			List foodList = Arrays.asList(foodFind);
			// check if the food names to find is in the same food index list web element object
			if (foodList.contains(foodFormat)) {
				// locate the add to cart button of specific index and click
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(3000);
				endo++;
				// check if the food to find (4) is completed to break the statement
				if (endo == foodFind.length) {
					break;
				}
			}
		}
	}
}

package selenium4;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class relative_locator {

	@Test
	public void rel_loc() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		Thread.sleep(3000);

		// locate text box web element
		WebElement editBox = driver.findElement(By.xpath("//input[@name='name']"));
		// locate web element above the text box and get text
		System.out.println(driver.findElement(with(By.tagName("label")).above(editBox)).getText());

		// locate date of birth label web element
		// WebElement labelDate =
		// driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		// locate below date of birth input element but will skip due to flex element
		// will then click submit button
		// driver.findElement(with(By.tagName("input")).below(labelDate)).click();

		// locate icecream label web element
		WebElement labelIce = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		// locate left checkbox and click it
		driver.findElement(with(By.tagName("input")).toLeftOf(labelIce)).click();

		// locate employment label web element
		WebElement labelEmploy = driver.findElement(By.xpath("//label[@for='exampleFormControlRadio1']"));
		// locate web element right the radio button and get text
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(labelEmploy)).getText());
	}

}

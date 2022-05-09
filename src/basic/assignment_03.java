package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment_03 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		WebDriverWait waitElem = new WebDriverWait(driver, Duration.ofMillis(5000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");

		driver.findElement(By.xpath("//div/label[2]/span")).click();

		waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		driver.findElement(By.xpath("//select[@class='form-control']")).click();
		waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='consult']")));
		driver.findElement(By.xpath("//option[@value='consult']")).click();
		
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		waitElem.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'btn-info')]")));
		List<WebElement> cardBtns = driver.findElements(By.xpath("//button[contains(@class,'btn-info')]"));
		for (int i = 0; i < cardBtns.size(); i++) {
			driver.findElements(By.xpath("//button[contains(@class,'btn-info')]")).get(i).click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	}

}

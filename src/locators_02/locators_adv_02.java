package locators_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locators_adv_02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String uname = "rahul";
		// chromedriver.exe path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();
		// implicit wait 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// webdriver go to URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// thread sleep
		Thread.sleep(1000);
		// find element by id and input
		driver.findElement(By.id("inputUsername")).sendKeys(uname);
		// find element by name and input
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		// find element by xpath parent child and click
		driver.findElement(By.xpath("//form[@class='form']/button[@class='submit signInBtn']")).click();

		// thread sleep
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(),
				"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),
				"Hello " + uname + ",");
		// thread sleep
		Thread.sleep(5000);
		// find element by xpath text and click
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
}

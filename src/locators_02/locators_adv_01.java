package locators_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators_adv_01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// chromedriver.exe path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();
		// implicit wait 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// webdriver go to URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		// find element by id and input
		driver.findElement(By.id("inputUsername")).sendKeys("rahol");
		// find element by name and input
		driver.findElement(By.name("inputPassword")).sendKeys("raholshittyacademy");
		// find element by class and click
		driver.findElement(By.xpath("//form[@class='form']/button")).click();
		// find element by css and get text
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		// find element by link text and click
		driver.findElement(By.linkText("Forgot your password?")).click();

		// thread sleep
		Thread.sleep(1000);
		// find element by xpath and input
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		// find element by xpath index and input
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("sheety");
		// find element by css index and input
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("1234567");
		// find element by xpath and click
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		// find element by scc parent child and get text
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		// find element by xpath parent child and click
		driver.findElement(By.xpath("//form/div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		// thread sleep
		Thread.sleep(1000);
		// find element by id and input
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		// find element by name and input
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		// find element by xpath parent child and click
		driver.findElement(By.xpath("//form[@class='form']/button[@class='submit signInBtn']")).click();
	}

}

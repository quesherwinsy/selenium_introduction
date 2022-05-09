package locators_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators_adv_04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();
		// implicit wait 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// webdriver go to URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// thread sleep
		Thread.sleep(1000);

		// xpath find element by parent-child following format
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		// xpath find element by child-parent following format
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[1]")).getText());
		
	}

}

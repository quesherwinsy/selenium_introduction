package locators_02;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windows_atr_05 {

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
		driver.get("https://www.google.com/");
		// thread sleep
		Thread.sleep(3000);
		// driver navigate to new URL
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		// driver navigate back to previous URL
		driver.navigate().back();
		// driver navigate forward to URL
		driver.navigate().forward();
	}

}

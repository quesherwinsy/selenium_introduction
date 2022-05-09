package webElem_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts_page_06 {

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
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// thread sleep
		Thread.sleep(3000);
		System.out.println("webpage title: " + driver.getTitle());

		// alert handling - web driver switch to alert
		String name_mo = "dodgy";
		// find text field and input name
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(name_mo);
		// find button (alert) and click
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		// switch to alert window and display
		System.out.println(driver.switchTo().alert().getText());
		// switch to alert window and click it's button (ok)
		driver.switchTo().alert().accept();
		// find button (confirm) and click
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		// switch to alert window and click it's button (cancel)
		driver.switchTo().alert().dismiss();
	}

}

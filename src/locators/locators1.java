package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// chromedriver.exe path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();
		// webdriver go to URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// webdriver find element by id and input
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		// webdriver find element by name and input
		driver.findElement(By.name("inputPassword")).sendKeys("shetty");
		// webdriver find element by class and click
		driver.findElement(By.className("signInBtn")).click();
	}
}

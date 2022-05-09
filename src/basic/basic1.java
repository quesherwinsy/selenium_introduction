package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("hello world");
		 * basic2 b = new basic2();
		 * b.ValidateHeader();
		 * System.out.println(b.ValidateHead());
		 */

		// chromedriver.exe path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}

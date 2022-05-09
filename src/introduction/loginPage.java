package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class loginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object chrome
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		System.out.println("webpage title: " + driver.getTitle());
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

		// get windows/tabs IDs handling, separate windows
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();

		// switch to child window
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];

		// switch to parent window
		driver.switchTo().window(parentID);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(emailID);

		// mouse hover action
		/*
		 * Actions mouseAct = new Actions(driver);
		 * mouseAct.moveToElement(driver.findElement(By.xpath(
		 * "//a[@class='blinkingText']"))).click().build().perform();
		 */
	}

}

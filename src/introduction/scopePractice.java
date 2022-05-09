package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scopePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object chrome
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("webpage title: " + driver.getTitle());
		System.out.println("frame count:" + driver.findElements(By.tagName("iframe")).size());

		// count all Links in a page - 27
		System.out.println("link count:" + driver.findElements(By.tagName("a")).size());

		// create mini webdriver (scope), count all Links in footer section - 20
		WebElement footerDr = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println("footer link count:" + footerDr.findElements(By.tagName("a")).size());

		// footer section get all 1st column Link - 5
		WebElement columnDr = footerDr.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		System.out.println("column link count:" + columnDr.findElements(By.tagName("a")).size());

		// click each link in the 1st column
		for (int i = 1; i < columnDr.findElements(By.tagName("a")).size(); i++) {
			String clickKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDr.findElements(By.tagName("a")).get(i).sendKeys(clickKeys);
			Thread.sleep(5000L);
		}

		// iterator get each title of open tabs
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> itr = tabs.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println("tab title: " + driver.getTitle());
			driver.switchTo().defaultContent();
		}

	}
}

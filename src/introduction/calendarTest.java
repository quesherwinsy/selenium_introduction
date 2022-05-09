package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object chrome
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions/");
		System.out.println("webpage title: " + driver.getTitle());

		// calendar web element handling
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();

		// calendar MONTH web element handling, traverse month
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"))
				.getText().contains("October")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		}

		// calendar DAY web element handling, get common attribute in calendar
		List<WebElement> days = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String dayText = driver.findElements(By.className("day")).get(i).getText();
			if (dayText.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

	}

}

package webElem_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkbox_radi_04 {

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
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// thread sleep
		Thread.sleep(3000);
		System.out.println("webpage title: " + driver.getTitle());

		// checkbox selection
		// testNG assert check if checkbox is not selected
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		// click the senior citizen checkbox
		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		// testNG assert check if checkbox is selected
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		// check number of checkboxes findElement(s)
		System.out.println("checkbox count " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

		// calendar selection
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger'][1]")).click();

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// calender select the current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// driver.findElement(By.xpath("//a[@class='ui-state-default
		// ui-state-highlight']")).click();
		// driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[2]/td[5]/a")).click();

		// check if 2nd calendar is disabled
		System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());

		// radio button selection
		// click the radio button (round trip)
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		
		// check if 2nd calendar is enabled (by checking attribute value)
		if (driver.findElement(By.xpath("//div[@class='picker-second']")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}

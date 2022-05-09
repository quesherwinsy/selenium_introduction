package webElem_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class end2end_flight_05 {

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

		// click the radio button (one way)
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		Thread.sleep(2000L);

		// check if 2nd calendar is DISabled (by checking attribute value)
		if (driver.findElement(By.xpath("//div[@class='picker-second']")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// dynamic dropdown selection
		// click dropdown (from)
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		// click dropdown value (BLR)
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// click dropdown (to)
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		// click dropdown value (MAA) by xpath index
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// click dropdown value (MAA) by xpath parent-child
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		Thread.sleep(2000L);
		// calender select the current date (depart date)
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// click the web element object (passengers) to display dropdown
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		// wait for the window to appear
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// click the adult plus icon 4 times
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		// click the done button
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		// check if the number of adults 5 is correct using testNG assert
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), "5 Adult");

		// static dropdown selection
		// locate the web element static dropdown object (currency)
		WebElement staticDD = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		// select the web element dropdown object.
		// Will only work if dropdown have SELECT tagname
		Select dropdown = new Select(staticDD);
		// choose dropdown by 3rd index and print
		dropdown.selectByIndex(3);
		System.out.println("1st select " + dropdown.getFirstSelectedOption().getText());
		// choose dropdown by attribute value and print
		dropdown.selectByVisibleText("AED");
		System.out.println("2nd select " + dropdown.getFirstSelectedOption().getText());
		// choose dropdown by text value and print
		dropdown.selectByValue("INR");
		System.out.println("3rd select " + dropdown.getFirstSelectedOption().getText());

		// radio button selection
		// click the radio button (round trip)
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();

		// click the button (search)
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

}

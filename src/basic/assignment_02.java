package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_02 {

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
		driver.get("https://www.cleartrip.com");
		// thread sleep
		Thread.sleep(3000);
		System.out.println("webpage title: " + driver.getTitle());

		/*driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[1]/option[@value='3']"))
				.click();
		driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]/option[@value='5']"))
				.click();*/
		
		WebElement staticAD = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[1]"));
		Select selAD =new Select(staticAD);
		selAD.selectByIndex(2);
		
		WebElement staticCH = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]"));
		Select selCH =new Select(staticCH);
		selCH.selectByIndex(4);

		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@aria-selected='true']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='mb-4']/a/strong[@class='pr-1']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("indigo");
		driver.findElement(By.xpath("//div[@class='col flex flex-middle']/button")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[@class='col-24']/div/span")).getText());
	}

}

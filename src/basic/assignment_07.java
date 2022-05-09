package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class assignment_07 {
//qaclickacademy.com
//click practice
//web table example print number of rows 11 columns 3
//print 2nd row of data

	@Test
	public void table_print() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='NO THANKS']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Practice']")).click();

		List<WebElement> tableRow = driver.findElements(By.cssSelector(".left-align fieldset table tbody tr"));
		System.out.println("table row count: " + tableRow.size());
		List<WebElement> tableCol = driver.findElements(By.xpath("//table/tbody/tr/th"));
		System.out.println("table column count: " + tableCol.size());
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		for (int i = 0; i < tableData.size(); i++) {
			System.out.println("data " + (i+1) + " " + tableData.get(i).getText());
		}
	}
}

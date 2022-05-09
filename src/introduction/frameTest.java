package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object chrome
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println("webpage title: " + driver.getTitle());
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		// frames handling switch to and back
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.switchTo().frame(0);

		// frames mouse drag and drop web element
		Actions mouseAct = new Actions(driver);
		WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropMe = driver.findElement(By.xpath("//div[@id='droppable']"));
		mouseAct.dragAndDrop(dragMe, dropMe).build().perform();
		
		// frames switch back
		driver.switchTo().defaultContent();
		
	}
}

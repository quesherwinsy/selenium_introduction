package introduction;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MiscTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// driver object Chrome
		WebDriver driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();

		// delete all cookie
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("webpage title: " + driver.getTitle());

		// take screenshot and save file
		// File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src, new
		// File("C:Users//SherwQUE//Desktop//seleni//screenshot.png"));

		// check broken link URLs with Java and assert
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert ass = new SoftAssert();

		for (WebElement link : links) {
			String urled = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(urled).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			ass.assertTrue(respCode < 400, "Link broken " + link.getText() + " code is " + respCode);
		}
		ass.assertAll();

	}
}

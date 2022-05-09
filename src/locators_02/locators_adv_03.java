package locators_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators_adv_03 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// chromedriver.exe path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		// webdriver.chrome.driver invoking browser, chrome browser
		WebDriver driver = new ChromeDriver();

		// call getpassword method to retrieve password
		String finalpass = getPassword(driver);
		// implicit wait 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// webdriver go to URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// thread sleep
		Thread.sleep(1000);
		// find element by id and input
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		// find element by name and input
		driver.findElement(By.name("inputPassword")).sendKeys(finalpass);
		// find element by xpath parent child and click
		driver.findElement(By.xpath("//form[@class='form']/button[@class='submit signInBtn']")).click();

	}

	// Method to get password text from the website
	public static String getPassword(WebDriver drvr) throws InterruptedException {
		// webdriver go to URL
		drvr.get("https://rahulshettyacademy.com/locatorspractice/");
		// find element by link text and click
		drvr.findElement(By.linkText("Forgot your password?")).click();
		// thread sleep
		Thread.sleep(1000);
		// find element by xpath and click
		drvr.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		// thread sleep
		Thread.sleep(1000);
		// find element by xpath and get text
		String upass = drvr.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		// split the strings to get password
		String[] epass = upass.split("'");
		String rpass = epass[1].split("'")[0];
		return rpass;
		// regex get text inside single quotes and remove the single quotes
		/*
		 * Pattern r = Pattern.compile("'(.*?)'"); Matcher m = r.matcher(upass); if
		 * (m.find()) { upass = m.group(0).replaceAll("^[\"']+|[\"']+$", "").toString();
		 * } else { System.out.println("No value found"); }
		 * System.out.println("Password is: " + upass);
		 */
	}

}

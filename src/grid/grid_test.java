package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid_test {
	@Test
	public void home_page_check() throws InterruptedException, MalformedURLException {
		// instantiate desired capability for setting driver
		DesiredCapabilities desCap = new DesiredCapabilities();

		// set capability to chrome browser, windows and accept ssl
		desCap.setBrowserName("chrome");
		desCap.setPlatform(Platform.WIN10);
		desCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// initialize remote driver URL(IP grid HUB, capability) selenium grid only
		WebDriver rdriver = new RemoteWebDriver(new URL("http://192.168.100.73:4444/"), desCap);

		rdriver.get("https://www.google.com/");
		rdriver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Rahul");
		System.out.println(rdriver.getTitle());
	}
}

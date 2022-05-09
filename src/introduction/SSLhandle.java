package introduction;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class SSLhandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// SSL handling accept certificates (deprecated JAVA)
		// DesiredCapabilities chCap = DesiredCapabilities.chrome();
		// chCap.acceptInsecureCerts();
		// chCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		// chCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions chromeOp = new ChromeOptions();
		// chrome option to accept ssl insecure certificate
		chromeOp.setAcceptInsecureCerts(true);
		chromeOp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromeOp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);

		// set chrome download location
		// reference https://chromedriver.chromium.org/capabilities
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		chromeOp.setExperimentalOption("prefs", prefs);

		// chrome option for extensions
		// chromeOp.addExtensions("");

		// Selenium proxy class initialize and set IP
		Proxy prox = new Proxy();
		prox.setHttpProxy("ipaddress:4444");
		chromeOp.setCapability("proxy", prox);

		// Chrome local browser (deprecated)
		// ChromeOptions chSsl = new ChromeOptions();
		// chSsl.merge(chromeOp);

		// driver object Chrome
		WebDriver driver = new ChromeDriver(chromeOp);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("webpage title: " + driver.getTitle());
	}

}

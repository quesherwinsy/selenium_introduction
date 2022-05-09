package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class flightbook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SherwQUE\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		
		//driver object chrome
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		//System.out.println("webpage title: " + driver.getTitle());
		
		//select dropdown object in webpage
		//WebElement staticDD = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		//select static dropdown with select object
		/*
		Select dropdown = new Select(staticDD);
		dropdown.selectByIndex(3);
		System.out.println("1st select " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println("2nd select " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println("3rd select " + dropdown.getFirstSelectedOption().getText());
		*/
		
		//static dropdown selection with testNG assert equal
		/*
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<4; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), "5 Adult");
		*/
		
		//dynamic dropdown selection
		/*
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		*/
		
		//autosuggest dropdown selection
		/*
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List <WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		*/
		
		//checkbox selection with testNG assert t/f
		/*
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		System.out.println("checkbox count " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		*/
		
		//calendar picker selection
		//driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger'][1]")).click();
		/*
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).click();
		//driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")).click();
		driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[2]/td[5]/a")).click();
		*/
		
		//radio button selection check enable/disable attribute
		/*
		System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		if(driver.findElement(By.xpath("//div[@class='picker-second']")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		*/
		
		//alert handling - web driver switch to alert
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("webpage title: " + driver.getTitle());
		String name_mo = "dodgy";
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(name_mo);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		driver.switchTo().alert().dismiss();
		
	}

}

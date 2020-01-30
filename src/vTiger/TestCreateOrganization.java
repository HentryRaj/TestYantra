package vTiger;
/**
 * 
 * @author HenTryRAj
 *
 */

import org.omg.CORBA.ULongLongSeqHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCreateOrganization {
//	static{
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
//	}
	
	
	@Test
	public void testScript() throws InterruptedException {
		WebDriverUtils ut = new WebDriverUtils();
		String userName = "admin";
		String password = "1234";
		String member = "aaa";
		String orgName ="ty_"+ ut.randomNumber(); 
		String option = "Organization Name";
		String phNum ="9876654";
		String email ="ty@gmail.com";
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		ut.woitForElementToLoad(driver);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("phone")).sendKeys(phNum);
		driver.findElement(By.name("email1")).sendKeys(email);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		ut.switchToChildwindow(driver);
		 WebElement dropdwn = driver.findElement(By.name("search_field"));
		 ut.select(dropdwn, option);
		 driver.findElement(By.name("search_text")).sendKeys(member, Keys.ENTER);
		driver.findElement(By.linkText(member)).click();
		
		ut.alertPopUpForAccept(driver);
		
		ut.switchToParentwindow(driver);
		WebElement saveBtn = driver.findElement(By.xpath("//input[@accesskey ='S']"));
		ut.waitForElementAndClick(driver, saveBtn);
		saveBtn.click();	
	
		WebElement org = driver.findElement(By.linkText("Organizations"));
		ut.waitForElementAndClick(driver, org);
		org.click();
	}
}

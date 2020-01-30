package vTiger;
/**
 * 
 * @author HenTryRAj
 *
 */


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;
public class TestCreateCampaign {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	
	WebDriver driver;
	@Test
	public void createProduct() throws InterruptedException {
		WebDriverUtils ut = new WebDriverUtils();
		String userName = "admin";
		String password = "1234";
		String proName ="po_"+ ut.randomNumber(); 
		String campName = "cp_"+ ut.randomNumber();
		String product = "rerer";
		String option = "Product Name";
		driver = new ChromeDriver();
		ut.woitForElementToLoad(driver);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title = 'Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(proName);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		driver.findElement(By.xpath("//td[@class = 'tabUnSelected'][10]")).click();
		WebElement camp= driver.findElement(By.name("Campaigns"));
		ut.actionForMoveTo(driver, camp);
		camp.click();
	     driver.findElement(By.xpath("//img[@title = 'Create Campaign...']")).click();
	     driver.findElement(By.name("campaignname")).sendKeys(campName);
	     driver.findElement(By.xpath("//img[@language ='javascript']")).click();
	     ut.switchToChildwindow(driver);
	    
	    WebElement drop = driver.findElement(By.name("search_field"));
	    ut.select(drop, option );
	    driver.findElement(By.id("search_txt")).sendKeys(product, Keys.ENTER);
	    driver.findElement(By.linkText(product)).click();
	    
	    ut.switchToParentwindow(driver);
	     WebElement saveBtn= driver.findElement(By.xpath("//input[@accesskey='S']"));
	     ut.waitForElementAndClick(driver, saveBtn);
	     saveBtn.click();
	    
	}
}
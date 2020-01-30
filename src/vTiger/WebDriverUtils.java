package vTiger;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author HenTryRAj
 *
 */
public class WebDriverUtils {
	/**
	 *Its is method for random values 
	 * @return
	 */
	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(10000);
	}
	/**
	 * used for select class and use the argument visible text 
	 * @param element

	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}
	/**
	 * used for select class and use the argument index value
	 * @param element
	 * @param optionInt
	 */
	public void select(WebElement element , int optionInt) {
		Select sel = new Select(element);
		sel.selectByIndex(optionInt);
	}
	/**
	 * used for implicitly wait
	 * @param driver
	 */
	public void woitForElementToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitForElementAndClick(WebDriver driver , WebElement element ) throws InterruptedException {
		int count =  0;
		while(count <= 20) {
			try {
				element.click();
				break;
			}
			catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	 /**
	  * 
	  * @param driver
	  */
	public void actionForDoubleClick(WebDriver driver ) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void actionForMoveTo(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	/**
	 * 
	 * @param driver
	 */
	public void alertPopUpForAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void alertPopUpForDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
		static String parentWind;
	    static String childWind;
	/**
	 * 
	 * @param driver
	 */
	public void switchToChildwindow(WebDriver driver) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> is = set.iterator();
		parentWind	= is.next();
		childWind	    = is.next();
		driver.switchTo().window(childWind);
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToParentwindow(WebDriver driver) {
		driver.switchTo().window(parentWind);
	}
}


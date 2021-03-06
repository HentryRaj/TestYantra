package dynamicwebtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/");
		driver.findElement(By.id("identifierId")).sendKeys("hentryraj94");
		driver.findElement(By.xpath("//span[text() = 'Next' ]")).click();
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("password"))));
		driver.findElement(By.name("password")).sendKeys("AssassinCreed94");
		driver.findElement(By.xpath("//span[text() = 'Next' ]")).click();
		String x = "//table[@class = 'F cf zt']/tbody/tr[*]/td[5]/div/span/span";
		Thread.sleep(3000);
	 	List<WebElement> list = driver.findElements(By.xpath(x));
	 	for(WebElement wb : list) {
	 		System.out.println(wb.getText());
	 	}
	}	
}

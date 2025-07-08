package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.xpath("(//li[@class='web-checkin'])[1]"));
		/*
		a.moveToElement(driver.findElement(By.xpath("(//li[@class='web-checkin'])[1]"))).build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='fareToolTip'])[1]")));
		
		
		System.out.println(driver.findElement(By.xpath("(//div[@class='fareToolTip'])[1]")).getText());
		*/
		
		a.moveToElement(driver.findElement(By.id("autosuggest"))).click().keyDown(Keys.SHIFT).sendKeys("indonesia")
		.doubleClick().build().perform();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("autosuggest")));
		
		//Moves to specific element
		a.moveToElement(move).build().perform();
		System.out.println(driver.findElement(By.xpath("(//div[@class='fareToolTip'])[1]")).getText());
		
		
		driver.quit();
	}
	
}

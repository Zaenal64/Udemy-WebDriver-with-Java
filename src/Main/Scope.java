package Main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1
		System.out.println(driver.findElements(By.tagName("a")).size());
 
		// 2 Count of footer section
		WebElement footDriver = driver.findElement(By.id("gf-BIG")); // Limiting webdriver scoope
		System.out.println(footDriver.findElements(By.tagName("a")).size());

		// 3
		WebElement coloumnDriver = driver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println(coloumnDriver.findElements(By.tagName("a")).size());

		// 4 Click on each link in the coloumn and check if the page are opening
		for (int i = 1; i < coloumnDriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
			Thread.sleep(3000);
			
		}// Opens all the tabs
		Set<String> abc = driver.getWindowHandles();//4
		Iterator<String> it = abc.iterator();
		
		do
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}while(it.hasNext());
		
		
		driver.quit();
	}

}

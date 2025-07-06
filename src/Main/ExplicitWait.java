package Main;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	
	////Implement explicit wait = sperate case
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

	String[] vegenNames = {"Brocolli", "Cucumber","Beetroot", "Tomato"};
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	Thread.sleep(3000);
	
	//Explicit Wait
	addItems(driver,vegenNames);
	driver.findElement(By.cssSelector("img[alt*='Cart']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
	
	driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
	driver.findElement(By.cssSelector("button.promoBtn")).click();
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	
	
	driver.quit();
		
	}
	
	
	public static void addItems(WebDriver driver, String[] vegenNames) {
		int j = 0;
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		//Get all vegen names, Format it to get actual vegetable name
		for(int i = 0; i<product.size(); i++) {
			String[] name = product.get(i).getText().split("-");
			// Brocolli - 1kg
			// Brocolli, 1kg
			//Trim = remove white space between char
			String formattedName = name[0].trim();
			
			//Convert array into array list for easy search
			//Check whether name you extracted is present in arrayList or not
			List vegenNamesList = Arrays.asList(vegenNames);
			
			
			//FIlter vegen name to specific name
			if(vegenNamesList.contains(formattedName)) {
				//Click button add to cart
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
				// only buy 3 products, 
				// We use length()method to get size of Array
				// We use size()method to get size of ArrayList
				if(j==vegenNames.length) {
					break;
				}
	
			}
			
		}
	}
}
	

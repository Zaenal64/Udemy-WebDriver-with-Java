package Main;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class implementationWait {

	public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	

	String[] vegenNames = {"Brocolli", "Cucumber","Beetroot", "Tomato"};
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	Thread.sleep(3000);
	addItems(driver,vegenNames);
	driver.findElement(By.cssSelector("img[alt*='Cart']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
	
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
	

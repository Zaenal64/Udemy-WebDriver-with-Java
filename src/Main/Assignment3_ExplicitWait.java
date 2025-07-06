package Main;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		// Turn off Password manager leak detection

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("password_manager_leak_detection", false);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		ChromeDriver driver = new ChromeDriver(options);
		String[] productNames = { "iphone", "Samsung", "Nokia", "Blackberry" };
		//// Implement explicit wait = sperate case
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Username
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");

		// Password
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");

		// Radio button User
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		// Accept alert
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

		// Static Dropdown
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Consultant");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// Checkbox
		driver.findElement(By.cssSelector("input[name*='terms']")).click();

		// Button sign In
		driver.findElement(By.cssSelector("#signInBtn")).click();

		// Next page (Select Product)
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));

		// button product
		addProducts(driver, productNames);

		// Button Checkout
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

		// Button Checkout final
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-success']")));
		driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
		
		//Checklist Tnc
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();
		
		//Button payment
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();		
	
		//Print alert success payment
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

		driver.quit();
	}

	public static void addProducts(WebDriver driver, String[] productNames) {
		int count = 0;
		List<WebElement> product = driver.findElements(By.cssSelector("h4.card-title"));
		// Get all vegen names, Format it to get actual vegetable name
		for (int i = 1; i < product.size(); i++) {
			for (int j = 0; j < productNames.length; j++) {
				if (product.get(i).getText().contains(productNames[j].toString())) {
					count++;
					driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
					if (count == productNames.length) {
						break;
					}

				}

			}

		}
	}

}

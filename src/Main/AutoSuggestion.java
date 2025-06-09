package Main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().fullscreen();

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		System.out.println(driver.findElement(By.id("autosuggest")).isDisplayed());
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Indonesia")) {
				option.click();
				break;
			};
		}
		Thread.sleep(3000);
		driver.quit();

	}

}

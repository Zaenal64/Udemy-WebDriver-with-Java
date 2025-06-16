package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1_Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		
		driver.findElement(By.id("checkBoxOption1")).isDisplayed();
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		if (driver.findElement(By.id("checkBoxOption1")).isEnabled()) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		if (driver.findElement(By.id("checkBoxOption1")).isSelected()) {
			Assert.assertTrue(true);
		} else {
			System.out.println("its disable again");
			Assert.assertFalse(false);
		}
		
		
		// Count the number of checkboxes
		System.out.println("Total Checkboxes: " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}

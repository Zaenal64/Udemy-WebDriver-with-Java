package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().fullscreen();

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		// Assert.assertFalse(true);
		// System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_IndArm']")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
		System.out
				.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_IndArm']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_IndArm']")).isSelected());

		// .ui-state-default.ui-state-highlight.ui-state-active

		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		
		
		// Count the number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 1;
		do {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		} while (i < 6);
		driver.findElement(By.id("btnclosepaxoption")).click();

		// Compairing actual rasult - Expected result
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.quit();
	}

}

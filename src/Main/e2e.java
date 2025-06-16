package Main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().fullscreen();

		// Select Country
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

		// Select one Way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();

		System.out.println("From: " + driver.findElement(By.xpath("//a[@value='DEL']")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='JED']")).click();

		System.out.println("To : " + driver.findElement(By.xpath("//a[@value='JED']")).getText());

		// Choose and set current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{
			System.out.println("its disabled");
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}

		driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).click();
		
		//Choose passenger = 5 adult
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 1; i < 5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(3000);
		
		//Select Cuurency(Static Dropdown)
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("USD");
		
		Thread.sleep(3000);
		// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		driver.findElement(By.cssSelector("input[type='Submit']")).click();
		// driver.findElement(By.xpath("//input[@value='Search']")).click();
		// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		driver.quit();

	}

}
package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	//Dropdown with seleted tag
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

	WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	
	Select dropdown = new Select(staticDropdown);
	dropdown.selectByIndex(2);
	System.out.println(dropdown.getFirstSelectedOption().getText());
	dropdown.selectByVisibleText("USD");
	System.out.println(dropdown.getFirstSelectedOption().getText());
	dropdown.selectByValue("INR");
	System.out.println(dropdown.getFirstSelectedOption().getText());
	
	driver.quit();
	}
	

}

package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sellintroduction {

	public static void main(String[] args) {
	// Invoking Browser
	// Chrome - ChromeDriver exten-> Methods close get
	// Firefox - FirefoxDriver -> Methods close get
	// Safari - Safari Driver -> Methods close get
	// WebDriver close get
	// WebDriver Methods + class methods
	
	// chromedriver.exe-> Chrome driver
	//System.setProperty("webdriver.chrome.driver", "D:/Driver/Chrome Driver/chromedriver-win64/chromedriver.exe");
	
	// webdriver.chrome.driver->value of path
	WebDriver driver = new ChromeDriver();
	
	// FIrefox Launch
	// Gecko Driver
	
	// webdriver.gecko.driver
	//System.setProperty("webdriver.gecko.driver", "D:/Driver/Gecko Driver/geckodriver.exe");
	WebDriver driver1 = new FirefoxDriver();
	
	
	// Microsoft Edge Launch
	// Edge Driver
	
	// webdriver.edge.driver
	//System.setProperty("webdriver.edge.driver", "D:/Driver/Edge driver/msedgedriver.exe");
	WebDriver driver2 = new EdgeDriver();
	
	
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	// Menutup web yang sedang digunakan saja
	driver.close(); 
	// Menutup semua web yang terkait
	//driver.quit(); 
	
	}
}

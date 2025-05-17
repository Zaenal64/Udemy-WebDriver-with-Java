package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	//implicit = global
	//explicit = spesifik
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("zaenal");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jenal");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jenal@sa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); // [2] = Second indeks
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jenal@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("912849238212");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

	}

}

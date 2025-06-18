package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertMessage {

	public static void main(String[] args) throws InterruptedException {
		String Name = "Zaenal";
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@name=\"enter-name\"]")).isDisplayed();
		driver.findElement(By.xpath("//input[@name=\"enter-name\"]")).sendKeys(Name);
		
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
		
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}

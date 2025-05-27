package Main;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // wait duration 5 second when click sign in button, (appear alert message)
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().fullscreen();
		
		System.out.println(driver.findElement(By.xpath("/html/body/header/div/button[1]/following-sibling::button[1]")).getText());
		////header/div/button[1]/following-sibling::button[1]
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parrent::div/button[2]")).getText());
		
		driver.close();
	}

}

package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5_Frame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));

		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));

		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.quit();
	}

}

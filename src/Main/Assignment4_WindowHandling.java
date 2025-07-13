package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class Assignment4_WindowHandling {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		// Set windows handlling
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[contains(text(),'New Window')]")));
		System.out.println("Text 1: " + driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

		driver.switchTo().window(parentId);
		w.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//h3[contains(text(),'Opening a new window')]")));
		System.out.println(
				"Text 2: " + driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

		driver.quit();
	}

}

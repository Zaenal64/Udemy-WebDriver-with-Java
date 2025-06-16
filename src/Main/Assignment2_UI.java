package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2_UI {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String name = "Zaenal Fahmi";
		String email = "zaenal@mail.com";
		String password = "@Test123";

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//select[@class='form-control']/option[contains(.,'Male')]")).click();
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("11/12/2001");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText(),
				"×\n" + "Success! The Form has been submitted successfully!.");
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		Thread.sleep(3000);
		driver.quit();

	}

}

package Main;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {


			WebDriver driver = new ChromeDriver();

			
			driver.get("http://facebook.com");
			driver.findElement(By.xpath("id('email')")).sendKeys("test");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			int a = 5;
			getSreenshot(driver);
			

		//	driver.manage().deleteCookieNamed("sessionKey");
		
		//click on any link
			//login page- verify login url
			
			
		/*	driver.get("http://google.com");
			
			File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("C:\\Users\\rahul\\screenshot.png"));*/
		
		
	}
	public static void getSreenshot(WebDriver driver) {
		driver.get("http://google.com");
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("D:\\Belajar QA\\screenshot.png"));
	}
	

}

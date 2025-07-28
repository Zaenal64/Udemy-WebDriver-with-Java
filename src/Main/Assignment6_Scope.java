package Main;
import java.util.Iterator;import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment6_Scope {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement chkbox2 = driver.findElement(By.id("checkBoxOption2"));
		chkbox2.click();
		// 1. Select any checkbox
		String text1 = chkbox2.getAttribute("value");
		System.out.println("Text1: " + text1);

		// 2. Grab the label of the selected checkbox //put into variable
		WebElement chkElement2Label = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]"));
		String text2 = chkElement2Label.getText();
		System.out.println("Text2: " + text2);


		// 3. Select an option in dropdown. Here option to select should come from step
		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement select3Label = driver.findElement(By.xpath("//option[@value='option2']"));
		select3Label.click();

		// 4. Enter the step 2 grabbed label text in Editbox
		WebElement chkElement4 = driver.findElement(By.id("name"));
		chkElement4.click();
		driver.findElement(By.id("name")).sendKeys(text2);
		Thread.sleep(3000);

		// 5. Click Alert and the verify if the grabbed from step 2, is present in the
		// pop up message
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains(text2)) {
			System.out.println("Allert message correct");
		} else {
			System.out.println("Wrong Alert");
		}

		driver.quit();

	}

}
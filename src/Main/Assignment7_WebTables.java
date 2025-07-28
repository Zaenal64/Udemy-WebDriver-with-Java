package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_WebTables {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement table = driver.findElement(By.name("courses"));
		
		
		WebElement headerRow = table.findElement(By.xpath(".//tr[1]"));
		for (WebElement headerCell : headerRow.findElements(By.xpath(".//th"))) {
		  System.out.print(headerCell.getText() + "\t");
		}
		System.out.println();
	
		
		 for (WebElement row : table.findElements(By.xpath(".//tr"))) {
	            if (!row.findElements(By.xpath(".//th")).isEmpty()) {
	                continue; // Skip header
	            }
	            for (WebElement cell : row.findElements(By.xpath(".//td"))) {
	                System.out.print(cell.getText() + "\t");
	            }
	            System.out.println();
		 }
		 
		 
		// 1. Print number of row in tables
		 int rows = table.findElements(By.xpath(".//tr")).size();
		 System.out.println("\n"+ "Number of rows: " + rows);
		// 2. Print number of coloum in tables
		 int cols = table.findElement(By.xpath(".//tr[1]")).findElements(By.xpath(".//th")).size();
		 if (cols == 0) {
		     cols = table.findElement(By.xpath(".//tr[2]")).findElements(By.xpath(".//td")).size();
		 }
		 System.out.println("Number of columns: " + cols);

		 
		// 3. Print second row of data
			 WebElement row2 = driver.findElement(By.xpath("(//tr)[3]"));
			 System.out.println(row2.getText());
		 
		
		driver.quit();

	}

}

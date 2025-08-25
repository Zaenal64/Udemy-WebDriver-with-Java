package Main;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("proxy", proxy);
		Map<String, Object>prefs = new HashMap<String, Object>();
		
		prefs.put("download.default_directory", "/directory/path");
//		FirefoxOptions options1 = new FirefoxOptions();
//		EdgeOptions options2 = new EdgeOptions();
		
//		options1.setAcceptInsecureCerts(true);
//		options2.setAcceptInsecureCerts(true);
		options.setExperimentalOption("prefs", prefs);
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}

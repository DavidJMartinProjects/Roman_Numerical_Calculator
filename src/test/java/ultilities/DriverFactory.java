package ultilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver open(String browserType){
		if(browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else{
			System.setProperty("webdriver.chrome.driver","C:\\Software\\selenium\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}

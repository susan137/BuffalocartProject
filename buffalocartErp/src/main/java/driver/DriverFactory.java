package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver createDriver(String browserName) {
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.out.println("The test is starting from chrome");
			System.setProperty("webdriver.chrome.driver", "/Users/susan/Downloads/chromedriver");
			driver=new ChromeDriver();
			
		}
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.out.println("The test is starting from firefox");
			System.setProperty("webdriver.gecko.driver", "/Users/susan/Downloads/geckodriver");
			driver=new FirefoxDriver();
			
		}
		
		if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", "/Users/susan/Downloads/chromedriver");
			driver=new ChromeDriver();
			
		}
		
		return driver;
	}
	
	

}

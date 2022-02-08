package buffalocartErp;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.DriverFactory;
import driver.DriverUtils;
import util.CaptureScreenshots;

public class BaseTester {
	
	WebDriver driver;
	
	
	
	@BeforeMethod
	@Parameters({"browser"}) 
	void bm(@Optional("chrome")String browser) {
		
		driver=DriverFactory.createDriver(browser);
		
		   
		// To maximize browser  
       
	
		driver=DriverUtils.maximize(driver);
    
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        
		driver.get("https://erp.buffalocart.com/");
		
		
		
		
		
		
	}
	
	
	
	
	@AfterMethod
	
	void am(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
		CaptureScreenshots.captureScreenshots(driver, result.getName());
		}
		
		//driver.quit();
	}

}

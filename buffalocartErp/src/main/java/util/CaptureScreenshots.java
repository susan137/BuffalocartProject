package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class CaptureScreenshots {
	
	public static void captureScreenshots(WebDriver driver,String filename) throws IOException {
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source,new File("./screenshots/"+filename+".png"));
			
		} catch (Exception e) {
			
			System.out.println("Exception while taking screenshots"+e.getMessage());
		}  
		
		
		
	}

}

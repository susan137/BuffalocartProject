package buffalocartErp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.DriverFactory;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BuffalocartHomePage;
import pages.BuffalocartLoginPage;
import pages.BuffalocartUserDashboardPage;
import pages.BuffalocartUserSignupPage;
import util.Testutil;

public class BuffalocartLoginTest extends BaseTester{
	
	
	
	
	
	@Test
	
	void logintest() throws InterruptedException {
		//driver=DriverFactory.createDriver(browser);
		
		BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
		loginpage.userLogin("admin","123456");
		
		BuffalocartHomePage homepage=new BuffalocartHomePage(driver);
		AssertJUnit.assertTrue(homepage.isLogoPresent());
		homepage.FindUser("User");
		
		
		
		//Assert users name contains "obsqura"
		BuffalocartUserDashboardPage userdasboard=new BuffalocartUserDashboardPage(driver);
		//Assert.assertEquals(userdasboard.verifyUsername("obsqura"), true);
		 //assertTrue(elementText.contains("obsqura"));
		
		}
		  private String filePath = "/Users/susan/Downloads/testdata.xlsx";
		  private String sheetName = "login";
		
		@DataProvider
		Object[][] getlogindata() throws IOException, InvalidFormatException {
			Object data[][]=Testutil.getData(filePath,sheetName);
			return data;
			
		}
		
		@Test(dataProvider="getlogindata")
		void loginBuffalo(String username1,String password1) {
			BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
			
			loginpage.userLogin(username1,password1);
			String expectedText="username or password information doesn't exist!";
			String actualText=loginpage.getAlertmessage();
			Assert.assertEquals(expectedText, actualText);
			
		
		}
}
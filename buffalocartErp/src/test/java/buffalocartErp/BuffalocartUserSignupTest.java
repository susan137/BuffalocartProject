package buffalocartErp;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.DriverFactory;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BuffalocartHomePage;
import pages.BuffalocartLoginPage;
import pages.BuffalocartUserDashboardPage;
import pages.BuffalocartUserSignupPage;
import util.CaptureScreenshots;

public class BuffalocartUserSignupTest extends BaseTester{
	
	
	
	
	
	@Test
	
	void logintest() throws InterruptedException, Exception {
		//driver=DriverFactory.createDriver(browser);
		
		BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
		loginpage.userLogin("admin","123456");
		
		BuffalocartHomePage homepage=new BuffalocartHomePage(driver);
		//AssertJUnit.assertTrue(homepage.isLogoPresent());
		homepage.FindUser("User");
		
		
		
		//Assert users name contains "obsqura"
		
		
		
			 //assertTrue(elementText.contains("obsqura"));
		
		
		
		//Create user
		BuffalocartUserDashboardPage userdasboard=new BuffalocartUserDashboardPage(driver);
		userdasboard.newUsername();
		BuffalocartUserSignupPage usersignup=new BuffalocartUserSignupPage(driver);
		usersignup.enterFullname("John Doe123");
		usersignup.enterEmployment_id("012834");
		usersignup.enterUsername("Doe1234");
		usersignup.enterPassword("1234");
		usersignup.enterconfirm_password("1234");
		usersignup.enterEmail("testDoe1234@test.com");
		usersignup.enterlocalDropdown("French (Benin)");
		//usersignup.enterlanguageDropdown("English");
		usersignup.enterPhone("123456789");
		usersignup.enterMobile("123456789");
		usersignup.enterSkype("testuser");
		//usersignup.fileupload("/Users/susan/Desktop/test.png");
		usersignup.enteruserTypeDropbox("Admin");
		//usersignup.enterdirectionDropdown("LTR");
		usersignup.enterPermissionRadio("Everyone                                            ");
		//CaptureScreenshots.captureScreenshots(driver, "signup");
		String actualTitle=usersignup.createUser();
		
		//Verify the form submission
		//String actualTitle=userdasboard.getPageTitle();
		String expectedTitle="User List1";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	
		
	}
	
	}

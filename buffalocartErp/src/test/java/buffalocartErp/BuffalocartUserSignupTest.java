package buffalocartErp;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.DriverFactory;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BuffalocartHomePage;
import pages.BuffalocartLoginPage;
import pages.BuffalocartUserDashboardPage;
import pages.BuffalocartUserSignupPage;

public class BuffalocartUserSignupTest extends BaseTester{
	
	
	
	
	
	@Test
	
	void logintest() throws InterruptedException {
		//driver=DriverFactory.createDriver(browser);
		
		BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
		loginpage.userLogin("admin","123456");
		
		BuffalocartHomePage homepage=new BuffalocartHomePage(driver);
		//AssertJUnit.assertTrue(homepage.isLogoPresent());
		homepage.FindUser("User");
		
		
		
		//Assert users name contains "obsqura"
		BuffalocartUserDashboardPage userdasboard=new BuffalocartUserDashboardPage(driver);
		
		//Assert.assertEquals(userdasboard.verifyUsername("obsqura"), true);
		
		
			 //assertTrue(elementText.contains("obsqura"));
		
		
		
		//Create user
		
		userdasboard.newUsername();
		BuffalocartUserSignupPage usersignup=new BuffalocartUserSignupPage(driver);
		usersignup.enterFullname("John Doe");
		usersignup.enterEmployment_id("123");
		usersignup.enterUsername("Test");
		usersignup.enterPassword("1234");
		usersignup.enterconfirm_password("1234");
		usersignup.enterEmail("test@test.com");
		usersignup.enterlocalDropdown("French (Benin)");
		//usersignup.enterlanguageDropdown("English");
		usersignup.enterPhone("123456789");
		usersignup.enterMobile("123456789");
		usersignup.enterSkype("testuser");
		//usersignup.fileupload("/Users/susan/Desktop/test.png");
		usersignup.enteruserTypeDropbox("Admin");
		//usersignup.enterdirectionDropdown("LTR");
		usersignup.enterPermissionRadio("Everyone                                            ");
		usersignup.createUser();
			
	
		
	}
	
	}

package buffalocartErp;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BuffalocartBugDashboardPage;
import pages.BuffalocartHomePage;
import pages.BuffalocartLoginPage;

public class BuffalocartBugDashboardTest extends BaseTester {
	
	@Test
	public void verifyBugTitle() {
		//Perform UserLogin	
		BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
		loginpage.userLogin("admin","123456");	
		
		//Click on Bug menu
		
		BuffalocartHomePage homepage=new BuffalocartHomePage(driver);
		homepage.clickOnMenuWithName("Bug");
		
		BuffalocartBugDashboardPage bugDashboard=new BuffalocartBugDashboardPage(driver);
		
		Assert.assertEquals(bugDashboard.verifyBug("Testdata"), true);
	}

}

package buffalocartErp;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.BuffalocartBugDashboardPage;
import pages.BuffalocartBugPage;
import pages.BuffalocartFileManagerPage;
import pages.BuffalocartHomePage;
import pages.BuffalocartLoginPage;

public class BuffalocartBugTest extends BaseTester{
	
	@Test
	public void bugManagement() {
		
		
	//Perform UserLogin	
	BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
	loginpage.userLogin("admin","123456");	
	
	//Click on Bug menu
	
	BuffalocartHomePage homepage=new BuffalocartHomePage(driver);
	homepage.clickOnMenuWithName("Bug");
	
	//Click on New Bug menu
	BuffalocartBugPage bugpage=new BuffalocartBugPage(driver);
	bugpage.newBug();
	
	
	bugpage.enterBugtitle("Incorrect data");
	bugpage.enterRelatedtoDropDown(" Opportunities ");
	bugpage.enterReporterDropdown("xty (Client)");
	bugpage.enterPriorityDropDown("Low");
	bugpage.enterSeverityDropDown("Show Stopper");
	//bugpage.enterDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
	//bugpage.enterReproducibility("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum");
	bugpage.enterBugstatusDropDown(" Resolved ");
	bugpage.enterAssignedToDropDown("Customize Permission");
    bugpage.saveBug();
    
    //Verify the newly created bug is showing in AllBug page
    BuffalocartBugDashboardPage bugDashboard=new BuffalocartBugDashboardPage(driver);
	Assert.assertEquals(bugDashboard.verifyBug("Testdata"), true);
	
	}

}

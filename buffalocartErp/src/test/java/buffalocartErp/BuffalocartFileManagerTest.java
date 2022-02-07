package buffalocartErp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.BuffalocartFileManagerPage;
import pages.BuffalocartLoginPage;

public class BuffalocartFileManagerTest extends BaseTester{
	
	@Test
	public void filemanagement() throws InterruptedException {
		
		
	//Perform UserLogin	
	BuffalocartLoginPage loginpage=new BuffalocartLoginPage(driver);
	loginpage.userLogin("admin","123456");	
	
	//Click on FileManager menu
	BuffalocartFileManagerPage filemanagerpage=new BuffalocartFileManagerPage(driver);
	filemanagerpage.clickOnMenuWithName("File Manager");
	
	filemanagerpage.createNewfolder();
	filemanagerpage.clickNewfolder();
	filemanagerpage.createNewfile();
	
	
	}
}

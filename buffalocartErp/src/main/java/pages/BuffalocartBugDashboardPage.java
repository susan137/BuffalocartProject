package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuffalocartBugDashboardPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='text-info']")
	public List<WebElement>bugTitle;
	
	
	public BuffalocartBugDashboardPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver =driver;
	
	}
	
	public boolean verifyBug(String actualString) {
		boolean flag=false;
	
		
		 
		for (int i = 0; i<bugTitle.size(); i++) {
			
			String elementText = bugTitle.get(i).getText();
			System.out.println(elementText);
			 
			 if(elementText.contains(actualString)) {
				 System.out.println(actualString); 
			 flag=true;
			 
				
			 	}
			
		}
		
		return flag;
		}
		

}

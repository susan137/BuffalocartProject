
	
	package pages;

	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import net.jodah.failsafe.internal.util.Assert;

	public class BuffalocartUserDashboardPage {
		
		WebDriver driver;
		
		@FindBy(xpath="//tr[@role='row']/td[3]")
		public List<WebElement> username;
		
		@FindBy(xpath="//a[text()='New User']")
		public WebElement newUsername;
		
		
		public BuffalocartUserDashboardPage(WebDriver driver){

	        PageFactory.initElements(driver,this);
	        this.driver =driver;
		
		}
	
		
		public boolean verifyUsername(String actualString) {
			boolean flag=false;
		
			//List<WebElement> actualString = userdasboard.verifyUsername();
			//System.out.println(actualString.size());
			 
			for (int i = 0; i<username.size(); i++) {
				
				String elementText = username.get(i).getText();
				 
				 if(elementText.contains("obsqura")) {
				 flag=true;
				 
					
				 	}
				// Assert.assertTrue(actualString.contains("obsqura"));
			}
			
			return flag;
			}
			
		
		
		
		public void newUsername() {
			// TODO Auto-generated method stub
			newUsername.click();
			
		}	
			
		}
		
	




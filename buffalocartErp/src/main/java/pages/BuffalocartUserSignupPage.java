package pages;

import java.util.List;

import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuffalocartUserSignupPage {

	WebDriver driver;
	
	
	@FindBy(xpath="//input[@name='fullname']")
	public WebElement fullname;
	@FindBy(xpath="//input[@name='employment_id']")
	public WebElement employment_id;
	@FindBy(xpath="//input[@name='username']")
	public WebElement username;
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	@FindBy(xpath="//input[@name='confirm_password']")
	public WebElement confirm_password;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement email;
	
	
	@FindBy(xpath="//span[text()='English (United States)']")
	public WebElement localDropdown;
	@FindBy(xpath="//ul[@class='select2-results__options']//li")
	public List<WebElement> localDropdownList;
	
	
	@FindBy(xpath="//span[text()='English']")
	public WebElement languageDropdown;
	@FindBy(xpath="//ul[@class='select2-results__options']/li")
	public List<WebElement> languageDropdownList;
	
	
	
	@FindBy(xpath="//span[text()='Select Designation']")
	public WebElement designation;
	@FindBy(xpath="//ul[@class='select2-results__options select2-results__options--nested']/li")
	public List<WebElement> designationDropdownList;
	
	
	
	
	
	@FindBy(xpath="//input[@placeholder='e.g user_placeholder_phone']")
	public WebElement phone;
	
	@FindBy(xpath="//input[@placeholder='e.g user_placeholder_mobile']")
	public WebElement mobile;
	
	@FindBy(xpath="//input[@placeholder='e.g user_placeholder_skype']")
	public WebElement skype;
	
	@FindBy(xpath="//select[@id='user_type']")
	public WebElement userTypeDropbox;
	
	@FindBy(xpath="//span[text()='RTL']")
	public WebElement directionDropdown;
	
	@FindBy(xpath="//div[@class='checkbox c-radio needsclick']/label/input[following-sibling::text()='Customize Permission ']")
	public WebElement permission;
	
	@FindBy(xpath="//button[text()='Create User']")
	public WebElement createuser;
	
	@FindBy(xpath="//input[@name='avatar']")
	public WebElement fileUpload;
	
	@FindBy(xpath="//input[@name='permission']/parent::label")
	public List<WebElement> rdo_permission;                  
	
	
	public BuffalocartUserSignupPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver =driver;
	
}

	
	public void enterFullname(String fullnametext) {
		WebDriverWait wait = new WebDriverWait (driver, 20);
		//wait.until(ExpectedConditions.VisibilityofElementLocated(By.xpath(""//button[@value='Save Changes']"")));
		
		fullname.sendKeys(fullnametext);
		
	}
	
	public void enterEmployment_id(String employment_idvalue) {
		
		employment_id.sendKeys(employment_idvalue);
		
	}
	
	public void enterUsername(String usernametext) {
		
		username.sendKeys(usernametext);
		
	}
	
	public void enterPassword(String passwordvalue) {
		
		password.sendKeys(passwordvalue);
		
	}
	
	public void enterconfirm_password(String confirm_passwordvalue) {
		
		confirm_password.sendKeys(confirm_passwordvalue);
		
	}
	
	public void enterEmail(String emailtext) {
		
		email.sendKeys(emailtext);
		
	}
	
	
	public void enterPhone(String phonevalue) {
		
		phone.sendKeys(phonevalue);
		
	}
	
	public void enterMobile(String mobilevalue) {
		
		mobile.sendKeys(mobilevalue);
		
	}
	
	public void enterSkype(String skypevalue) {
		
		skype.sendKeys(skypevalue);
		
	}
	
	/*public boolean retryingFindClick(By by) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            driver.findElement(by).click();
	            result = true;
	            break;
	        } catch(StaleElementException e) {
	        }
	        attempts++;
	    }
	    return result;
	}*/

	public void enterlocalDropdown(String localDropdowntext) {
		
		
		boolean result = false;
	    int attempts = 0;
	    
	    //JavascriptExecutor js = (JavascriptExecutor) driver;  
	    //js.executeScript("arguments[0].click()",localDropdown);
        
	   
		localDropdown.click();
		while(attempts < 2) {
	        try {
		for (WebElement ele:localDropdownList) {
			String listele=ele.getText();
			if (listele.contains(localDropdowntext)){
				ele.click();
			}
			}
	        }catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	        }
		}
	
	public void enterlanguageDropdown(String languageDropdowntext) {
		
		boolean result = false;
	    int attempts = 0;
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;  
	    js.executeScript("arguments[0].click()",languageDropdown);
	    //languageDropdown.click();
		while(attempts < 2) {
	        try {
		for (WebElement ele:languageDropdownList) {
			String listele=ele.getText();
			if (listele.contains(languageDropdowntext)){
				ele.click();
			}
			}
	        }catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	        }
		}
		
/*public void enterlanguageDropdown(String userTypeDropdowntext) {
		
		Select sel=new Select(userTypeDropbox);
		
		sel.selectByVisibleText(userTypeDropdowntext);
		
	}*/
	
	public void enteruserTypeDropbox(String userTypeDropdowntext) {
		
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='user_type']")));
        
		
		Select sel=new Select(userTypeDropbox);
		
		sel.selectByVisibleText(userTypeDropdowntext);
		
		
		if(designation.isDisplayed()) {
			enterDesignaionDropdown("Manager");
			
		}
		
		
	}
	
	
	public void enterDesignaionDropdown(String designationDropdowntext) {
		
		
		boolean result = false;
	    int attempts = 0;
	    
	    //JavascriptExecutor js = (JavascriptExecutor) driver;  
	    //js.executeScript("arguments[0].click()",localDropdown);
        
	   
	    designation.click();
		while(attempts < 2) {
	        try {
		for (WebElement ele:designationDropdownList) {
			String listele=ele.getText();
			if (listele.contains(designationDropdowntext)){
				ele.click();
			}
			}
	        }catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	        }
		}
	
	
	
	
	public void enterdirectionDropdown(String directionDropdowntext) {
		
		Select sel=new Select(directionDropdown);
		
		sel.selectByVisibleText(directionDropdowntext);
		
	}
	
	public void enterPermissionRadio() {
		permission.click();
		
	}
	public void enterPermissionRadio(String rdo_permissionText) {
		
		
		
		List<WebElement>rdo_AssignedTo=driver.findElements(By.xpath("//input[@name='permission']/parent::label"));
		for (WebElement ele:rdo_permission) {
			String listele=ele.getText();
			//System.out.println(listele);
			if (listele.contains(rdo_permissionText)){
				
				ele.click();
				//clickSelectUsersChkbox("admin");
				
			}
			}
		
	}
	public void createUser() {
		// TODO Auto-generated method stub
		createuser.click();
		
		
		
	}
	
	public void fileupload(String fileUpload1) {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;  
	    js.executeScript("arguments[0].click()",fileUpload);
		
		//fileUpload.click();
		try {
		
		
		
		
		//String fileUpload="/Users/susan/Desktop/test.png";
		
		StringSelection stringselection=new StringSelection(fileUpload1);
		
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
		
	    Robot robot=new Robot();
		 

        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
   		robot.keyPress(KeyEvent.VK_META);
  		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
  		robot.delay(500);

		//Open Goto window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		robot.delay(5000);
		//Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);

		//Press Enter key to close the Goto window and Upload window
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		}catch(Exception ex) {
		ex.printStackTrace();	
		}
		
		
		
		
	}
	}
	


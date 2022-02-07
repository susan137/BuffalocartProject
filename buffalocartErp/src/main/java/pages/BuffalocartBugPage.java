package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class BuffalocartBugPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()=\"New Bugs\"]")
	public WebElement newbug;
	
	@FindBy(xpath="//input[@name='issue_no']")
	public WebElement issueno;
	
	@FindBy(xpath="//input[@name='bug_title']")
	public WebElement bugtitle;
	
	
	@FindBy(xpath="//select[@name='related_to']")
	public WebElement relatedtoDropDown;
	
	//select[@name='reporter']
	@FindBy(xpath="//span[text()='demo (Admin)']")
	
	public WebElement reporter;
	@FindBy(xpath="//ul[@class='select2-results__options']//li")
	public List<WebElement> reporterDropDownList;
	
	
	@FindBy(xpath="//select[@name='priority']")
	public WebElement priority;
	
	@FindBy(xpath="//select[@name='severity']")
	public WebElement severity;
	
	@FindBy(xpath="//textarea[@name='bug_description']")
	public WebElement description;
	
	@FindBy(xpath="//textarea[@name='reproducibility']")
	public WebElement reproducibility;
	
	
	@FindBy(xpath="//select[@name='bug_status']")
	public WebElement bugstatus;

	
	@FindBy(xpath="//input[@name='permission']/parent::label")
	public List<WebElement> rdo_AssignedTo;
	
	@FindBy(xpath="//input[@name='assigned_to[]']/parent::label")
	public List<WebElement> chk_SelectUsers;
	
	
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement savebuton;
	
	//create constructor
	
	public BuffalocartBugPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver =driver;
	
	}
	public void newBug() {
		newbug.click();
	}
	
	public void enterBugtitle(String bugtitlevalue) {
		
		bugtitle.sendKeys(bugtitlevalue);
		
	}
	
	public void enterDescription(String descriptionvalue) {
		WebDriverWait wait= (new WebDriverWait(driver, 30));
		wait.until(ExpectedConditions.visibilityOf(description));
		
		description.sendKeys(descriptionvalue);
		
	}
	public void enterReproducibility(String reproducibilityvalue) {
		WebDriverWait wait= (new WebDriverWait(driver, 5));
		wait.until(ExpectedConditions . elementToBeClickable (reproducibility));
		
		reproducibility.sendKeys(reproducibilityvalue);
		
	}
	
	public void enterRelatedtoDropDown(String relatedtoDropDowntext) {
		
		
		Select sel=new Select(relatedtoDropDown);
		
		sel.selectByVisibleText(relatedtoDropDowntext);
		
	}
	
	

	public void enterReporterDropdown(String reportertext) {
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;  
	    //js.executeScript("arguments[0].click()",reporter);
		
		boolean result = false;
	    int attempts = 0;
	    
		reporter.click();
		List<WebElement>reporterDropDownList=driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		while(attempts < 2) {
	        try {
		for (WebElement ele:reporterDropDownList) {
			String listele=ele.getText();
			if (listele.contains(reportertext)){
				System.out.println(listele);
				ele.click();
			}
			}
	        }catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	        }
		}
	
	
	public void enterPriorityDropDown(String relatedtoDropDowntext) {
		
		Select sel=new Select(priority);
		
		sel.selectByVisibleText(relatedtoDropDowntext);
		
	}
	public void enterSeverityDropDown(String severityDropDowntext) {
		
		Select sel=new Select(severity);
		
		sel.selectByVisibleText(severityDropDowntext);
		
	}
	
	public void enterBugstatusDropDown(String BugstatusDropDowntext) {
		
		Select sel=new Select(bugstatus);
		
		sel.selectByVisibleText(BugstatusDropDowntext);
		
	}
	public void enterAssignedToDropDown(String AssignedDropdownText) {
		
		
		
		List<WebElement>rdo_AssignedTo=driver.findElements(By.xpath("//input[@name='permission']/parent::label"));
		for (WebElement ele:rdo_AssignedTo) {
			String listele=ele.getText();
			//System.out.println(listele);
			if (listele.contains(AssignedDropdownText)){
				
				ele.click();
				clickSelectUsersChkbox("admin");
				
			}
			}
		
	}
	
	public void clickSelectUsersChkbox(String chkText) {
		
		List<WebElement>rdo_AssignedTo=driver.findElements(By.xpath("//input[@name='assigned_to[]']/parent::label"));
		for (WebElement ele:rdo_AssignedTo) {
			String listele=ele.getText();
			//System.out.println(listele);
			if (listele.contains(chkText)){
				
				ele.click();
				
				
			}
			}
		
		
	}
	
	public void saveBug() {
		
		savebuton.click();
	}
	
	

}

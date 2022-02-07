package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuffalocartLoginPage {
	
	@FindBy(xpath="//input[@name='user_name']")
	public WebElement user;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	public WebElement alertMessage;
	
	WebDriver driver;
	
	public BuffalocartLoginPage(WebDriver driver){

	        PageFactory.initElements(driver,this);
	        this.driver =driver;
		
	}
	
	
	
	public void enterUsername(String username) {
		// TODO Auto-generated method stub
		user.sendKeys(username);
		
	}
	
	public void enterPassword(String password1) {
		// TODO Auto-generated method stub
		password.sendKeys(password1);
		
	}
	
	public void login() {
		// TODO Auto-generated method stub
		submit.click();
		
	}
	
	public String getAlertmessage() {
		
		String alertText=alertMessage.getText();
		
		return alertText;
		
		
		
		
	}
	public void userLogin(String un,String pwd) {
		
		enterUsername(un);
		enterPassword(pwd);
		login();
		
	}
	
}

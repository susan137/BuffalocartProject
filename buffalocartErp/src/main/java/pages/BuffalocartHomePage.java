package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.jodah.failsafe.internal.util.Assert;

public class BuffalocartHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='user-block-status']/img")
	public WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Search in menu...']")
	public WebElement search;
	
	@FindBy(xpath="//span[text()='User']")
	public WebElement user;


	public BuffalocartHomePage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver =driver;
	
	}
	
	public boolean isLogoPresent() {
		
		
		return logo.isDisplayed();
		
		
		// TODO Auto-generated method stub
		
	}
	
	public void FindUser(String searchEle) {
		
		search.sendKeys(searchEle);
		user.click();
		
		
		// TODO Auto-generated method stub
		
	}
	
	public void clickOnMenuWithName(String menuname)
	{
	String menuxpath="//a[contains(@title,'"+menuname+"')]";
	driver.findElement(By.xpath(menuxpath)).click();

	}

	
	
}

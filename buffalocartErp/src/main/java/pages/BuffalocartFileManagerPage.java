package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuffalocartFileManagerPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@title='New folder']")
	public WebElement createNewfolder;
	
	@FindBy(xpath="//div[@title='NewFolder 51']")
	public WebElement clickNewfolder;
	
	@FindBy(xpath="//div[@title='New text file']")
	public WebElement createNewFile;
	
	public BuffalocartFileManagerPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver =driver;
	
	}
	
	
	public void clickOnMenuWithName(String menuname)
	{
	String menuxpath="//a[contains(@title,'"+menuname+"')]";
	driver.findElement(By.xpath(menuxpath)).click();
	

	}
	
	
	public void createNewfolder() throws InterruptedException{
		
		Thread.sleep(1000);
	
		createNewfolder.click();
		
		
		}
	
	public void clickNewfolder(){
		
		Actions ac=new Actions(driver);
		ac.moveToElement(clickNewfolder).click().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='NewFolder']")));
		
		ac.moveToElement(clickNewfolder).doubleClick().build().perform();
		
		//createNewfile();
		}
	
	public void createNewfile(){
		
		Actions ac=new Actions(driver);
		ac.moveToElement(createNewFile).click().build().perform();
		//createNewFile.click();
		
		}

}

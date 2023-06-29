package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[text()='My Account']") WebElement MyAccount;
	@FindBy(xpath="//a[text()='Register']") WebElement Register;
	@FindBy(xpath="//a[text()='Login']") WebElement bttnlogin;
	
	//Action Methods
	public void clickmyaccount()
	{
		MyAccount.click();
	}
	
	public void clickregister()
	{
		Register.click();
	}
	
	public void clicklogin()
	{
		bttnlogin.click();
	}
	

}

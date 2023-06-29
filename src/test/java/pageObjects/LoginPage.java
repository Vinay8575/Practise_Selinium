package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(name="email") WebElement txtEmailAddress;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']") WebElement btnClickLogin;
	
	//Action Methods
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickLoginbttn()
	{
		btnClickLogin.click();
	}

}

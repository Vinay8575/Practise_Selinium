package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement myaccountmsgconfirm;
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']") WebElement btnLogout;
	
	@FindBy(xpath="//span[text()='My Account']") WebElement bttn1;
	@FindBy(xpath="//a[@class='dropdown-item'][text()='Logout']") WebElement bttn2;
	
	
	public Boolean msgConfirm() {
		try {
	return (myaccountmsgconfirm.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	public void ccbb()
	{
		bttn1.click();
		bttn2.click();
	}

}

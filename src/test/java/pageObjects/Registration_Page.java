package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_Page extends BasePage {
	
	public Registration_Page(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(name="firstname") WebElement Firstname;
	@FindBy(name="lastname") WebElement Lastname;
	@FindBy(name="email") WebElement Email;
	@FindBy(name="password") WebElement Password;
	@FindBy(name="agree") WebElement Privacypolicy;
	@FindBy(xpath="//button[@type='submit']") WebElement Continue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement Messageconfirmation;
	
	//Actions Method
	public void setfirstname(String fname)
	{
		Firstname.sendKeys(fname);
	}
	public void setlastname(String lname)
	{
		Lastname.sendKeys(lname);
	}
	public void setemail(String email)
	{
		Email.sendKeys(email);
	}
	public void setpassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void privacypolicy()
	{
		Privacypolicy.click();
	}
	public void clickbutton()
	{
		Continue.click();
	}
	public String msgconfirm()
	{
		try {
		return (Messageconfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

}

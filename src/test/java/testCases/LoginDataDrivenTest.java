package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_logindata(String email,String password,String exp)
	{
		try {
		
			logger.info("**** Starting test test_logindata ***");
			
		HomePage hp=new HomePage(driver);
		logger.info("**** Clicking on my account link ***");
		hp.clickmyaccount();
		logger.info("**** Clicking on login link ***");
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("**** providing data to the application ****");
		lp.setEmail(email);
		lp.setPassword(password);
		logger.info("**** Clicking on login button ***");
		lp.clickLoginbttn();
		
		MyAccountPage mp=new MyAccountPage(driver);
		logger.info("**** Validating the user login ***");
		boolean targetpage=mp.msgConfirm();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				logger.info("**** Validating 1st condition ***");
				mp.ccbb();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				logger.info("**** Validating 2nd condition ***");
				mp.ccbb();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finished test test_logindata ***");
	}

}

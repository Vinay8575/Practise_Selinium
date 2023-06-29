package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Loginpagetest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		try {
			
	    logger.info("**** Starting test TC_002_Loginpagetest ***");
	    
		HomePage hp=new HomePage(driver);
		logger.info("**** Clicking on my account link ***");
		hp.clickmyaccount();
		logger.info("**** Clicking on login link ***");
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("**** providing data to the application ****");
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		logger.info("**** Clicking on login button ***");
		lp.clickLoginbttn();
		
		MyAccountPage mp=new MyAccountPage(driver);
		logger.info("**** Validating the MyAccountpage ***");
		Boolean status=mp.msgConfirm();
		Assert.assertEquals(status, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished test TC_002_Loginpagetest ***");
	}
	

}

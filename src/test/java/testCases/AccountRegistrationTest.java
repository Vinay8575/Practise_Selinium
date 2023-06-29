package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Registration_Page;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	@Test(groups={"Regression","Master"})
	public void testAccount()
	{
		try {
			logger.debug("*** Application logs***");
		logger.info("***Starting AccountRegistrationTest***");
		HomePage hp=new HomePage(driver);
		logger.info("*** Clicking My Account***");
		hp.clickmyaccount();
		logger.info("*** Clicking Register_Account page***");
		hp.clickregister();
		
		Registration_Page rp=new Registration_Page(driver);
		logger.info("*** Providing the data to the application ***");
		rp.setfirstname(RandomStringGenerator());
		rp.setlastname(RandomStringGenerator());
		rp.setemail(RandomStringGenerator()+"@gmail.com");
		rp.setpassword(randomAlpha());
		Thread.sleep(3000);
		rp.privacypolicy();
		Thread.sleep(3000);
		logger.info("*** Clicking create account button***");
		rp.clickbutton();
		String cnfmsg=rp.msgconfirm();
		logger.info("*** Validating confirm message ***");
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished AccountRegistrationTest***");
	}
	
	

}

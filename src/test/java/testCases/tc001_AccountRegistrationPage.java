package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class tc001_AccountRegistrationPage extends BaseClass {
	
	
	@Test
	public void verify_account_registration() {
		
		logger.info("-----Starting TC001_AccountRegistartionPage-----");
		
		try {
		HomePage hp=new HomePage(driver);
		
		hp.ClickAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.RegisterAccount();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		
		
		logger.info("Providing Customer Details");
		repage.setFirstName(randomString().toUpperCase());
		repage.setLastName(randomString().toUpperCase());
		repage.setEmail(randomString()+"@gmail.com");
		repage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		
		repage.checkPrivacy();
		repage.clickContinue();
		
		
		logger.info("Validating Excepted Message");
		String conf=repage.confirmationMsg();
	
	
		Assert.assertEquals(conf, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug log");
			Assert.fail();
	     }
		
		logger.info("-----Test Finished-----");
		
	}
	
	
}

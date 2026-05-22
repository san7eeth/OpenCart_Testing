package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp) { 
		try {
			logger.info("----Login DDT Started----");
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			
			hp.ClickAccount();
			logger.info("Clicked on MyAccount Link");
			
			hp.LoginAccount();
			logger.info("Clicked on Log in Link");
			
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.loginButton();
			
			MyAccountPage acc = new MyAccountPage(driver);
			boolean target = acc.ismyAccountExisits();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(target == true) {
					logger.info("Login Passed");
					acc.Logout();
					Assert.assertTrue(true);
				}
				else {
					logger.info("Login Failed");
					Assert.assertTrue(false);
				}
			}
			else if(exp.equalsIgnoreCase("Invalid")) {
				if(target == true) {
					logger.info("Login Passed");
					acc.Logout();
					Assert.assertTrue(false);
				}
				else {
					logger.info("Login Failed");
					Assert.assertTrue(true);
				}
			}
			logger.info("----Login DDT Finished----");
		}catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug log");
			Assert.fail();
		}
		logger.info("----Login DDT Finished----");
	}
}

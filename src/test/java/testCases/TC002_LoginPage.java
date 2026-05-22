package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginPage extends BaseClass{

	@Test(groups={ "Sanity","Master"})
	public void verify_login_page() {
		
		logger.info("-----Account login Started-----");
		
		try {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		
		
		hp.ClickAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.LoginAccount();
		logger.info("Clicked on Log in  Link");
		
		
		
		

		lp.setEmail(p.getProperty("email"));
		logger.info("Login attempted with email: " + p.getProperty("email"));
		
		
		lp.setPassword(p.getProperty("password"));
		logger.info("Password used: " + p.getProperty("password"));
		
		lp.loginButton();

		
		
		MyAccountPage acc=new MyAccountPage(driver);
		boolean target=acc.ismyAccountExisits();
		
		Assert.assertTrue(target);
		}
		catch (Exception e){
			Assert.fail();
		}
		
		logger.info("----Login Page Finished----");
	}

}

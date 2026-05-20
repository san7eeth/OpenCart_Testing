package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement firstName;
	
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement lastName;
	
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement telephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement confirmPassword;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement privacycheckbox;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement continuebtn;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement confirmationMsg;
	
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setTelephone(String phone) {
		telephone.sendKeys(phone);
	}
	
	public void setPassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void setConfirmPassword(String cpswd) {
		confirmPassword.sendKeys(cpswd);
	}
	
	public void checkPrivacy() {
		privacycheckbox.click();
	}
	
	
	public void clickContinue() {
		continuebtn.click();
	}
	
	public String confirmationMsg() {
		try {
		return (confirmationMsg.getText());
	}catch (Exception e){
		return (e.getMessage());
	  }
	}
	
}

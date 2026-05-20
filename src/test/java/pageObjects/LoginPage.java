package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-email")
    WebElement email;

    @FindBy(id="input-password")
    WebElement password;

    @FindBy(xpath="//input[@value='Login']")
    WebElement btnLogin;

    public void setEmail(String mail) {
        email.clear();
        email.sendKeys(mail);
    }

    public void setPassword(String psd) {
        password.clear();
        password.sendKeys(psd);
    }

    public void loginButton() {
        btnLogin.click();
    }
}
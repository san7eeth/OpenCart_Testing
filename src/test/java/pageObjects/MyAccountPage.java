package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h2[text()='My Account']")
    WebElement myaccount;
    
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnklogout;

    public boolean ismyAccountExisits() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(myaccount));
            return myaccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void Logout() {
    	lnklogout.click();
    }
}
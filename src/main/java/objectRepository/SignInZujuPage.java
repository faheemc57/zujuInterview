package objectRepository;

import genericLibrary.BaseClass;
import genericLibrary.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInZujuPage extends BaseClass {
    public SignInZujuPage() throws IOException {
    }
    public static SignInZujuPage signInZujuPage= PageFactory.initElements(driver, SignInZujuPage.class);

    @FindBy(xpath = "//h2[.='Welcome to ZUJU KICKOFF']")
    private WebElement signInText;

    @FindBy(xpath = "//input[@placeholder='Enter your email address']")
    private WebElement emailEditBox;
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    private WebElement passwordEditBox;
    @FindBy(xpath = "//button[.='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@id='close-button']//*[name()='svg']")
    private WebElement closeSignInPage;

    public WebElement getCloseSignInPage(){
        return closeSignInPage;
    }

    public void clickOnCloseSignInPage() throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(closeSignInPage,10);
        closeSignInPage.click();
    }

    public WebElement getSignInText() throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(signInText, 10);
        return signInText;
    }
    public WebElement getEmailEditBox() {
        return emailEditBox;
    }

    public void loginToZuju(String email, String password) throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(emailEditBox,10);
        emailEditBox.sendKeys(email);
        passwordEditBox.sendKeys(password);
        loginButton.click();
    }


    public WebElement getPasswordEditBox() {
        return passwordEditBox;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}

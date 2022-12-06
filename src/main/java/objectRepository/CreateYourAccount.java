package objectRepository;

import genericLibrary.BaseClass;
import genericLibrary.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

//Join Us
public class CreateYourAccount extends BaseClass {
    public CreateYourAccount() throws IOException {
    }

    public static CreateYourAccount createYourAccount= PageFactory.initElements(driver, CreateYourAccount.class);

    @FindBy(xpath = "//a[normalize-space()='Log In']")
    private WebElement logIn;

    public WebElement getLogIn(){
        return logIn;
    }
    public void clickOnLogin() throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(logIn, 10);
        logIn.click();
    }



}

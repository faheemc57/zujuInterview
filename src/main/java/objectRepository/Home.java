package objectRepository;

import genericLibrary.BaseClass;
import genericLibrary.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Home extends BaseClass {
    public static Home home= PageFactory.initElements(driver, Home.class);

    public Home() throws IOException {
    }

    @FindBy(xpath ="//h4[.='Teams']")
    private WebElement teamsReputation;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement joinUs;

    public WebElement getJoinUs(){
        return joinUs;
    }

    public void clickOnJoinUs() throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(joinUs, 10);
        joinUs.click();
    }

    public WebElement getTeamsReputation() {
        return teamsReputation;
    }
    public void clickOnTeamsReputation() throws InterruptedException {
        WaitUtils.waitForInterClickElementToLoad(teamsReputation,20);

        teamsReputation.click();
    }
}

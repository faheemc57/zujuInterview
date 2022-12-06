package objectRepository;

import genericLibrary.BaseClass;
import genericLibrary.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teams extends BaseClass {
    public static Teams teams= PageFactory.initElements(driver, Teams.class);

    public Teams() throws IOException {
    }
    @FindBy(xpath = "//input[@placeholder='Search for a team']")
    private WebElement searchBox;

    @FindBy(xpath = "//p[.='Manchester City']")
    private WebElement manchesterCity;

    @FindBy(xpath = "//div[contains(@class,'infinite-scroll-component')]//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-p6ctl0']//button[@aria-label='favorite']//*[name()='svg']")
    private WebElement favButtonManchesterCity;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-15jlbw0'][normalize-space()='Manchester City'])[1]")
    private WebElement favouriteManchesterCity;

    @FindBy(xpath = "//div[@class='infinite-scroll-component__outerdiv']//p")
    private List<WebElement> allTeamsPresent;

    @FindBy(xpath = "//div[@class='infinite-scroll-component__outerdiv']//p[.='Viet A 11']")
    private WebElement vietA11;

    public WebElement getVietA11(){
        return vietA11;
    }

    public List<WebElement> getAllTeamsPresent(){
        return allTeamsPresent;
    }

    public List<String> fetchAllTeamText() throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(vietA11, 10);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        WaitUtils.waitForCompleteElementToLoad(vietA11, 10);
        WaitUtils.waitForCompleteElementToLoad(vietA11, 10);
        List<String> teamTextList = allTeamsPresent.stream().map(team->team.getText()).collect(Collectors.toList());
        return teamTextList;
    }


    public WebElement getSearchBox() {
        return searchBox;
    }
    public void searchATeam(String teamName) throws InterruptedException {
        WaitUtils.waitForInterClickElementToLoad(searchBox,10);
        searchBox.sendKeys(teamName);
}

    public WebElement getManchesterCity() {
        return manchesterCity;
    }
    public void clickOnMAnchesterCity(){
        manchesterCity.click();
    }

    public WebElement getFavouriteManchesterCity() {
        return favouriteManchesterCity;
    }
    public boolean isFavouriteManchesterCityPresent(){
        return favouriteManchesterCity.isDisplayed();
    }

    public WebElement getFavButtonManchesterCity() {
        return favButtonManchesterCity;
    }
    public void clickOnFavButton() throws InterruptedException {
        WaitUtils.waitForCompleteElementToLoad(favButtonManchesterCity,10);
        favButtonManchesterCity.click();// selecting for fav
    }
}

package testScripts;

import genericLibrary.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static objectRepository.SignInZujuPage.signInZujuPage;
import static objectRepository.Home.home;
import static objectRepository.CreateYourAccount.createYourAccount;
import static objectRepository.Teams.teams;




public class ZujuTest extends BaseClass {
    public ZujuTest() throws IOException {
    }

    @Test(testName = "verify the sign in page of zuju with title", priority = 1)
    public void signInTextTest() throws InterruptedException {
        String signInText= signInZujuPage.getSignInText().getText();
        System.out.println("signInTextIs: "+ signInText);
        Assert.assertEquals(signInText, "Welcome to ZUJU KICKOFF", "Sign in text is not matching");
    }

    @Test(testName = "Verify the homePage is displayed if the user does not opt to signIn and close the page", priority = 2)
    public void closeSignInPage() throws InterruptedException {
        signInZujuPage.clickOnCloseSignInPage();
        String homeTitle= driver.getTitle();
        System.out.println("homeTitle is: "+homeTitle);
        Assert.assertTrue(homeTitle.contains("Zuju Kickoff | Watch Football Matches"));
    }

    @Test(testName = "verify the title of home page after sign in with user name and password", priority = 3)
    public void signInToZuju() throws InterruptedException {
        String email= inputUtils.getProperties("email");
        String password= inputUtils.getProperties("password");
        System.out.println("email and psw is: "+email+" and "+password);
        home.clickOnJoinUs();
        createYourAccount.clickOnLogin();
        signInZujuPage.loginToZuju(email, password);
        String title= driver.getTitle();
        System.out.println("title is: "+title);
        Assert.assertTrue(title.contains("Zuju Kickoff"));
    }

    @Test(testName = "Verify team list", priority = 4)
    public void verifyTeamList() throws InterruptedException {
        home.clickOnTeamsReputation();
        List<String> teamTextList=teams.fetchAllTeamText();
        System.out.println(teamTextList);
        Assert.assertTrue(teamTextList.contains("Chelsea"));
        Assert.assertTrue(teamTextList.contains("Arsenal"));
        Assert.assertTrue(teamTextList.contains("Manchester United"));
    }

    @Test(testName ="Verify reputation page", priority = 5)
        public void verifyReputation() throws InterruptedException {
        String inputTeam= inputUtils.getProperties("teamName");
        System.out.println("teamName is: "+inputTeam);
        teams.searchATeam(inputTeam);
        teams.clickOnFavButton();
        Assert.assertTrue(teams.isFavouriteManchesterCityPresent());
        teams.clickOnFavButton(); // un favourating the team

    }

}

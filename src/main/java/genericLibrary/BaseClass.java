package genericLibrary;

import constants.PathEndPoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseClass {
    public InputUtils inputUtils= new InputUtils();
    public static WebDriver driver;
    public static Actions actions;


    public BaseClass() throws IOException {

    }

    @BeforeClass
    public void launchBrowser(){
        driver= new ChromeDriver();
        actions= new Actions(driver);
        String signInUrl= inputUtils.getProperties("url")+ PathEndPoints.SIGNINZUJU;
        System.out.println("url is: "+signInUrl);
        WaitUtils.waitForPageToLoad();
        driver.get(signInUrl);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}

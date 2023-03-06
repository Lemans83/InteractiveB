package Tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Properties;

public class HomePageTest {

    Properties prop;
    WebDriver driver;
    BasePage basePage;
    HomePage homePage;

    @BeforeTest
    public void SetUp(){
        basePage = new BasePage();
        prop = basePage.init_prop();
        driver = basePage.init_driver(prop);
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void createAccount(){
        homePage.clickCreatAccount();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

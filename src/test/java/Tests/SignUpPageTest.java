package Tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import java.util.Properties;
import java.util.Random;

public class SignUpPageTest{

    Properties prop;
    WebDriver driver;
    BasePage basePage;
    HomePage homePage;
    SignUpPage signUpPage;


    @BeforeTest
    public void SetUp(){
        basePage = new BasePage();
        prop = basePage.init_prop();
        driver = basePage.init_driver(prop);
        homePage = new HomePage(driver);
        signUpPage = homePage.clickCreatAccount();
    }

    @Test(priority = 1)
    public void createAcct(){
        signUpPage.enterSignUpInputs();
    }

    @Test(priority = 2)
    public void validateConfirmationPage(){
        signUpPage.validateConfirmationPage();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

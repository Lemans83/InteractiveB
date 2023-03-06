package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;

// 1. By locators
    By getstartedLocator = By.xpath("(//a[text()='Get Started'])[1]");
    By createAccountLocator = By.xpath("(//a[text()='Create an Account'])[1]");

// 2. Constructor of HomePage class
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

// 3. Methods
    public void verifyCurrentUrllink(){
        driver.getCurrentUrl();
    }
    public boolean verifyGetStartedLink(){
      return  driver.findElement(getstartedLocator).isDisplayed();
    }
    public void doSignUp(){
        driver.findElement(getstartedLocator).click();
   }

   public SignUpPage clickCreatAccount(){
        doSignUp();
        driver.findElement(createAccountLocator).click();
        return new SignUpPage(driver);
   }
}

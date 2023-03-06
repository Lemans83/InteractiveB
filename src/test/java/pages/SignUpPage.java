package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class SignUpPage extends BasePage {

    WebDriver driver;

 // By locators
    By emailAddress = By.xpath("//input[@id='emailAddress']");
    By userName = By.xpath("//input[@id='username']");
    By password = By.xpath("//input[@id='password']");
    By confirmPwd = By.xpath("//input[@id='password2']");
    By firstName = By.xpath("//input[@id='firstName']");
    By lastName = By.xpath("//input[@id='lastName']");
    By DOB = By.xpath("//input[@id='date']");
    By SecQuestionOne = By.xpath("//select[@id='question0']");
    By answerOne = By.xpath("//input[@id='answer0']");
    By SecQuestionTwo = By.xpath("//select[@id='question1']");
    By answerTwo = By.xpath("//input[@id='answer1']");
    By SecQuestionThree = By.xpath("//select[@id='question2']");
    By answerThree = By.xpath("//input[@id='answer2']");
    By agreementLink = By.xpath("//a[contains(text(), 'PortfolioAnalyst Subscriber Agreement')]");
    By agreeBtn = By.xpath("//button[@id='paAgreement_positive']");
    By createAcctBtn = By.xpath("//button[@id='accountCreationButton']");
    By confirmationPageEmail = By.xpath("//h2//strong[contains(text(), 'confirm your email address')]");

    public String email = "interactive2023@gmail.com";

    // Constructor of Sign up page
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public String generateString() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(9);
        for (int i = 0; i < 9; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }

    public void waitForVisibilityOfAnElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOf(element));
    }
    public void waitForVisibilityOfAnElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOf(returnWebElement(by)));
    }
    public void waitForVElementToBeClickable(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeys (By by, String text){
        waitForVElementToBeClickable(by);
        waitForVisibilityOfAnElement(by);
        driver.findElement(by).click();
        driver.findElement(by).sendKeys(text);
    }

    public WebElement returnWebElement(By by){
        return driver.findElement(by);
    }
    public String usernameRandom = generateString();
    public String question1 = "What is the name of a school you attended?";
    public String question2 = "In what city were you married?";
    public String question3 = "What is the middle name of your eldest child?";
    public WebElement findWebElement(By locator) {
        return driver.findElement(locator);
    }
    public String selectInDropdown(By element, String value) {
        waitForVElementToBeClickable(element);
        WebElement ddElement = findWebElement(element);
        Select dropdown = new Select(ddElement);
        dropdown.selectByValue(value);
        return value;
    }
    public void scrollToElementIntoView (By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);}

    public void clickIt(By locator) {
        waitForVisibilityOfAnElement(locator);
        waitForVElementToBeClickable(locator);
        findWebElement(locator).click();
    }
    public boolean isElementDisplayed(By locator) {
        waitForVisibilityOfAnElement(locator);
        return findWebElement(locator).isDisplayed();
    }
    public void wait(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Execution
    public void enterSignUpInputs() {
        sendKeys(emailAddress, email);
        System.out.println("Clicked");
        waitForVisibilityOfAnElement(returnWebElement(emailAddress));
        sendKeys(userName, usernameRandom);
        sendKeys(password, "tester12");
        sendKeys(confirmPwd, "tester12");
        sendKeys(firstName, "David");
        sendKeys(lastName, "Richards");
        sendKeys(DOB, "1995-02-15");
        selectInDropdown(SecQuestionOne, question1);
        sendKeys(answerOne, "Columbia");
        selectInDropdown(SecQuestionTwo, question2);
        sendKeys(answerTwo, "New York City");
        scrollToElementIntoView(SecQuestionThree);
        selectInDropdown(SecQuestionThree, question3);
        sendKeys(answerThree, "George");
        clickIt(agreementLink);
        clickIt(agreeBtn);
        clickIt(createAcctBtn);
        wait(7000);
    }

    public void validateConfirmationPage(){
        Assert.assertTrue(isElementDisplayed(confirmationPageEmail));
    }

}

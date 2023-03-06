package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public Properties prop;
    public WebDriver init_driver(Properties prop){
       String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        else if (browserName.equalsIgnoreCase("safari")){
            WebDriverManager.getInstance(SafariDriver.class).setup();
            driver = new SafariDriver();

        }
        else {
            System.out.println(browserName + "is not found, please pass the right Name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        return driver;
    }
    public Properties init_prop(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/java/configPage/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
           e.printStackTrace();
            System.out.println("configuration file is not found");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}

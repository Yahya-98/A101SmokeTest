package DriverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverSetup {


    WebDriver driver;
    public WebDriver getDriver() {

        //Chrome options for notification and popup blocking
        ChromeOptions options = new ChromeOptions();
        //  options.addArguments("user-data-dir=C:\\Users\\PC0\\AppData\\Local\\Google\\Chrome\\User Data\\TestProfile");
        //  options.addArguments("--profile-directory=TestProfile");
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized"); // start chrome maximized
        options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //removes the banner

        //this line created the chromedriver
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
        // this line for get url*/

    }


}

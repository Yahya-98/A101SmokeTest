package Pages;

import DriverSetup.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class BasePage {
    WebDriver driver;
    WebDriverWait wt;
    static Map data;

    Actions actions;



    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wt = new WebDriverWait(driver,10);
    }

    By popup = By.cssSelector("//div[@class='closePopupPersona']");
    By cerez = By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    By giyim = By.xpath("//a[@title='GİYİM & AKSESUAR']");
    By dizalticorap = By.xpath("//a[@title='Dizaltı Çorap']");

    public void popupclose(){
        data = ConfigReader.dataProperties();
        String url = String.valueOf(data.get("url"));
        driver.get(url);
        driver.switchTo().activeElement().findElement(cerez).click();

    }

    public void selectDizalticorapPage(){
        actions = new Actions(driver);
        WebElement giyimHover = driver.findElement(giyim);
        actions.moveToElement(giyimHover).perform();

        WebElement corapHover = driver.findElement(dizalticorap);
        wt.until(ExpectedConditions.elementToBeClickable(corapHover)).click();

    }
}

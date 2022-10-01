package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wt;
    Actions actions;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wt = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By cerez = By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    By giyim = By.xpath("//a[@title='GİYİM & AKSESUAR']");
    By dizalticorap = By.xpath("//a[@title='Dizaltı Çorap']");

    public void popupclose() {

        driver.get("https://www.a101.com.tr/");
        driver.switchTo().activeElement().findElement(cerez).click();

    }

    public void selectDizalticorapPage() {

        actions = new Actions(driver);
        WebElement giyimHover = driver.findElement(giyim);
        actions.moveToElement(giyimHover).perform();

        WebElement corapHover = driver.findElement(dizalticorap);
        wt.until(ExpectedConditions.elementToBeClickable(corapHover)).click();

    }
}

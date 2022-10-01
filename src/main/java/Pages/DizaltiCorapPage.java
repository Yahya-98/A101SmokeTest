package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DizaltiCorapPage {

    WebDriver driver;
    WebDriverWait wt;

    By filterBlackColour = By.xpath("//label[@for='attributes_integration_colourSİYAH']");

    By addBasketBtn = By.xpath("//em[@class='icon-sepetekle']");

    By checkProductColour = By.xpath("//div[@class='selected-variant-text']");

    By addBasketProductSelected = By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']");

    By wievBasketBtn = By.xpath("//a[@class='go-to-shop']");

    public DizaltiCorapPage(WebDriver driver) {

        this.driver = driver;
        this.wt = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void filterBlackProduct() {

        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(filterBlackColour))).click();


    }

    public boolean addBasket() {

        wt.until(ExpectedConditions.urlToBe("https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/?attributes_integration_colour=S%C4%B0YAH"));
        wt.until(ExpectedConditions.elementToBeClickable(addBasketBtn));
        driver.findElement(addBasketBtn).click();
        return true;
    }

    public String checkProductColour() {

        return wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(checkProductColour))).getText();

    }

    public void addBasketProduct() {

        driver.findElement(addBasketProductSelected).click();

    }

    public void viewBasket() {

        wt.until(ExpectedConditions.elementToBeClickable(driver.switchTo().activeElement().findElement(wievBasketBtn))).click();
    }


}

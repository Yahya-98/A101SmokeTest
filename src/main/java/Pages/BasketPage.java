package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
    WebDriver driver;
    WebDriverWait wt;
    By acceptBasketBtn = By.xpath("//a[@class='button green checkout-button block js-checkout-button']");
    public BasketPage(WebDriver driver){
        this.driver = driver;
        this.wt = new WebDriverWait(driver,10);
    }

    public void acceptBasket(){
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(acceptBasketBtn))).click();
    }

}

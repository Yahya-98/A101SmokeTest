package Pages;

import DriverSetup.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class OrderPage {
    WebDriver driver;
    WebDriverWait wt;

    Actions actions;

    static Map data;

    By continueWithoutMemberBtn = By.xpath("//a[@class='auth__form__proceed js-proceed-to-checkout-btn']");
    By emailLane = By.xpath("//input[@name='user_email']");
    By continueBtn = By.xpath("//button[@class='button block green']");
    By newAdreesBtn = By.xpath("//a[@class='new-address js-new-address']");
    By inputAdressName = By.xpath("//input[@placeholder='Ev adresim, iş adresim vb.']");
    By inputName = By.xpath("//input[@name='first_name']");
    By inputLastname = By.xpath("//input[@name='last_name']");
    By inputPhoneNumber = By.xpath("//input[@name='phone_number']");
    By selectCity = By.xpath("//option[@value='40']");
    By selectTownshipLane = By.xpath("//select[@name='township']");
    By selectTownship = By.xpath("//option[@value='448']");
    By selectDistrictLane = By.xpath("//select[@name='district']");
    By selectDistrict = By.xpath("//option[@value='35388']");
    By inputAdress = By.xpath("//textarea[@class='js-address-textarea']");

    By btnSave = By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']");
    By selectCargo = By.xpath("//label[@class='js-checkout-cargo-item']");
    By btnSaveAndSubmit = By.xpath("//button[@class='button block green js-proceed-button']");
    By selectGarantiPay = By.xpath("//div[@class='payment-tab payment-tab-gpay js-payment-tab ']");
    By acceptContract = By.xpath("//input[@class='checkout__contract__checkbox js-checkout-agreement']");

    By btnPayWithGarantiPay = By.xpath("//a[@class='button green js-gpay-payment']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
        this.wt = new WebDriverWait(driver,10);
    }

    public void continueWithoutMember(){

        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueWithoutMemberBtn))).click();

    }

    public void setEmail(){

        data = ConfigReader.dataProperties();
        String email = String.valueOf(data.get("email"));
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailLane))).sendKeys(email);
        driver.findElement(continueBtn).click();
    }

    public void newAdressCrete(){
        actions = new Actions(driver);

        String adressName = String.valueOf(data.get("AdressName"));
        String name = String.valueOf(data.get("Name"));
        String lastName = String.valueOf(data.get("Lastname"));
        String phoneNumber = String.valueOf(data.get("PhoneNumber"));
        String adressLane = String.valueOf(data.get("adress"));

        wt.until(ExpectedConditions.elementToBeClickable(newAdreesBtn)).click();

        wt.until(ExpectedConditions.elementToBeClickable(inputAdressName)).sendKeys(adressName);
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputLastname).sendKeys(lastName);
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(selectCity).click();


        WebElement township = driver.findElement(selectTownshipLane);
        actions.moveToElement(township).perform();
        wt.until(ExpectedConditions.elementToBeClickable(selectTownship)).click();

        WebElement district = driver.findElement(selectDistrictLane);
        actions.moveToElement(district).perform();
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(selectDistrict))).click();
        driver.findElement(inputAdress).sendKeys(adressLane);
        driver.findElement(btnSave).click();


    }

    public void selectCargo(){
        wt.until(ExpectedConditions.elementToBeClickable(selectCargo)).click();
    }

    public void saveAndContinue(){
        wt.until(ExpectedConditions.elementToBeClickable(btnSaveAndSubmit)).click();
    }

    public String checkGoesToPaymentScreen(){

        wt.until(ExpectedConditions.elementToBeClickable(selectGarantiPay)).click();
        wt.until(ExpectedConditions.elementToBeClickable(acceptContract)).click();
        driver.findElement(btnPayWithGarantiPay).click();


        return driver.getCurrentUrl();

    }


}

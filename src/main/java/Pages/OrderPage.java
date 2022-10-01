package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class OrderPage {
    WebDriver driver;
    WebDriverWait wt;
    Actions actions;
    static Faker fake = new Faker();
    static String Adress;
    static String FirstName;
    static String LastName;
    static String PhoneNumber;
    static String Email;


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
    By selectCargo = By.xpath("//div[@class='price']");
    By btnSaveAndSubmit = By.xpath("//button[@class='button block green js-proceed-button']");
    By selectGarantiPay = By.xpath("//div[@class='payment-tab payment-tab-gpay js-payment-tab ']");
    By acceptContract = By.xpath("//div[@class='checkout__contract__text']");

    By btnPayWithGarantiPay = By.xpath("//a[@class='button green js-gpay-payment']");

    public OrderPage(WebDriver driver) {

        this.driver = driver;
        this.wt = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void continueWithoutMember() {

        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueWithoutMemberBtn))).click();

    }

    public void setEmail() {


        Email = fake.internet().emailAddress();
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(emailLane))).sendKeys(Email);
        driver.findElement(continueBtn).click();
    }

    public void newAdressCrete() {
        actions = new Actions(driver);
        Adress = fake.address().fullAddress();
        FirstName = fake.name().firstName();
        LastName = fake.name().lastName();
        PhoneNumber = "5" + fake.phoneNumber().cellPhone().replaceAll("-", "");

        wt.until(ExpectedConditions.elementToBeClickable(newAdreesBtn)).click();

        wt.until(ExpectedConditions.elementToBeClickable(inputAdressName)).sendKeys("TestAdress");
        driver.findElement(inputName).sendKeys(FirstName);
        driver.findElement(inputLastname).sendKeys(LastName);
        driver.findElement(inputPhoneNumber).sendKeys(PhoneNumber);
        driver.findElement(selectCity).click();


        WebElement township = driver.findElement(selectTownshipLane);
        actions.moveToElement(township).perform();
        wt.until(ExpectedConditions.elementToBeClickable(selectTownship)).click();

        WebElement district = driver.findElement(selectDistrictLane);
        actions.moveToElement(district).perform();
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(selectDistrict))).click();
        driver.findElement(inputAdress).sendKeys(Adress);
        driver.findElement(btnSave).click();


    }

    public void selectCargo() {
        wt.until(ExpectedConditions.elementToBeClickable(btnSaveAndSubmit));
        driver.findElement(selectCargo).click();
    }

    public void saveAndContinue() {
        wt.until(ExpectedConditions.elementToBeClickable(btnSaveAndSubmit));
        driver.findElement(btnSaveAndSubmit).click();
    }

    public boolean checkGoesToPaymentScreen() {

        wt.until(ExpectedConditions.elementToBeClickable(selectGarantiPay)).click();

        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(acceptContract))).click();
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnPayWithGarantiPay))).click();
        wt.until(ExpectedConditions.urlToBe("https://sanalposprov.garanti.com.tr/servlet/gt3dengine"));

        return true;

    }


}

import DriverSetup.DriverSetup;
import Pages.BasePage;
import Pages.BasketPage;
import Pages.DizaltiCorapPage;
import Pages.OrderPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {
    private static Logger log = Logger.getLogger(TestPage.class.getName());
    static DriverSetup driverSetup = new DriverSetup();
    static WebDriver driver;
    static BasePage basePage;
    static DizaltiCorapPage dizaltiCorapPage;
    static BasketPage basketPage;
    static OrderPage orderPage;

    @BeforeClass
    public void setup() {

        log.info("Test Start");
        driver = driverSetup.getDriver();
        basePage = new BasePage(driver);
        dizaltiCorapPage = new DizaltiCorapPage(driver);
        basketPage = new BasketPage(driver);
        orderPage = new OrderPage(driver);
    }

    @AfterClass
    public void finish() {

        log.info("Test End");
        driver.quit();
    }

    @Test
    public void step01PopupAccept() {

        log.info("Pop up Accept");
        basePage.popupclose();
    }

    @Test
    public void step02SelectProductPage() {

        log.info("Go to dizaltı çorap page");
        basePage.selectDizalticorapPage();
    }

    @Test
    public void step03SelectColourBlack() {

        log.info("Click filter to black");
        dizaltiCorapPage.filterBlackProduct();
    }

    @Test
    public void step04SelectProduct() {

        log.info("Select first product");
        dizaltiCorapPage.addBasket();
    }

    @Test
    public void step05CheckProductColour() {

        log.info("Check product colour");
        Assert.assertEquals(dizaltiCorapPage.checkProductColour(), "Seçılen Renk: SİYAH");
    }

    @Test
    public void step06AddBasketProduct() {

        log.info("Product added to basket");
        dizaltiCorapPage.addBasketProduct();
    }

    @Test
    public void step07WievBasket() {

        log.info("Wiev Basket ");
        dizaltiCorapPage.viewBasket();
    }

    @Test
    public void step08AcceptBasket() {

        log.info("Accept Basket");
        basketPage.acceptBasket();
    }

    @Test
    public void step09ContinueWithoutMember() {

        log.info("Select Continue without member");
        orderPage.continueWithoutMember();
    }

    @Test
    public void step10SetEmail() {

        log.info("Set random email");
        orderPage.setEmail();
    }

    @Test
    public void step11CreateNewAdress() {

        log.info("Set random adress ");
        orderPage.newAdressCrete();
    }

    @Test
    public void step12SelectCargo() {

        log.info("Select kargo");
        orderPage.selectCargo();
    }

    @Test
    public void step13SaveAndContinue() {

        log.info("Go to payment page");
        orderPage.saveAndContinue();
    }

    @Test
    public void step14CheckGoesToPaymentScreen() {

        log.info("Check payment page is come");
        Assert.assertTrue(orderPage.checkGoesToPaymentScreen());
    }
}

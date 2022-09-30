import DriverSetup.DriverSetup;
import Pages.BasePage;
import Pages.BasketPage;
import Pages.DizaltiCorapPage;
import Pages.OrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {
    static DriverSetup driverSetup = new DriverSetup();
    static WebDriver driver;
    static BasePage basePage;
    static DizaltiCorapPage dizaltiCorapPage;
    static BasketPage basketPage;
    static OrderPage orderPage;

    @BeforeClass
    public void setup(){
        driver = driverSetup.getDriver();
        basePage =  new BasePage(driver);
        dizaltiCorapPage = new DizaltiCorapPage(driver);
        basketPage = new BasketPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void step01PopupClose(){
        basePage.popupclose();
    }

    @Test
    public void step02SelectProductPage(){
        basePage.selectDizalticorapPage();
    }
    @Test
    public void step03SelectColourBlack(){
        dizaltiCorapPage.filterBlackProduct();
    }
    @Test
    public void step04SelectProduct(){
        dizaltiCorapPage.addBasket();
    }

    @Test
    public void step05CheckProductColour(){
        Assert.assertEquals(dizaltiCorapPage.checkProductColour(),"Seçılen Renk: SİYAH");
    }

    @Test
    public void step06AddBasketProduct(){
        dizaltiCorapPage.addBasketProduct();
    }
    @Test
    public void step07WievBasket(){
        dizaltiCorapPage.viewBasket();
    }
    @Test
    public void step08AcceptBasket(){
        basketPage.acceptBasket();
    }
    @Test
    public void step09ContinueWithoutMember(){
        orderPage.continueWithoutMember();
    }
    @Test
    public void step10SetEmail(){
        orderPage.setEmail();
    }
    @Test
    public void step11CreateNewAdress(){
        orderPage.newAdressCrete();
    }
    @Test
    public void step12SelectCargo(){
        orderPage.selectCargo();
    }
    @Test
    public void step13SaveAndContinue(){
        orderPage.saveAndContinue();
    }
    @Test
    public void step14CheckGoesToPaymentScreen(){
        Assert.assertEquals(orderPage.checkGoesToPaymentScreen(),"https://sanalposprov.garanti.com.tr/servlet/gt3dengine");
    }
}

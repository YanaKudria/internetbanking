import Pages.*;
import Utils.DataProviderClass;
import Utils.SiteNavigator;
import Utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest {


    @BeforeMethod
    public void BeforeEachTest(){
        WebDriverManager.openBrowser();
    }

    @Test
    public void successDemoLoginTest() {
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        Assert.assertTrue(HomePage.getUserName().equals("Королёва Ольга"));
}

    @Test
    public void makeSureThatBalanceIsPositive(){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        HomePage.openAccountPage();
        Assert.assertTrue(AccountsPage.makeSureThatBalanceIsPositive() > 0);
    }

    @Test
    public void checkIfTheMessageWasSent(){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        HomePage.clickMassageIcon();
        MessagePage.sendNewMessage("How do I get an official account statement?");
        MessagePage.openLastSentMessage();
        Assert.assertTrue(MessagePage.getMessageOfLastMessage().contains("How do I get an official account statement?"));
    }

    @Test
    public void makeSureCurrencyExchangeWasSuccessful(){
        CurrencyPage currencyPage = new CurrencyPage();
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        HomePage.openExchangePage();
        currencyPage.makeExchange(currencyPage.USD, currencyPage.RUB, "100");
        Assert.assertTrue(currencyPage.successExchangeMessageIsPresent());

    }

    @Test(dataProvider = "getDataFromCSV", dataProviderClass = DataProviderClass.class)
    public void sendingFewMessages(String Message){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        HomePage.clickMassageIcon();
        MessagePage.sendNewMessage(Message);
        MessagePage.openLastSentMessage();
        Assert.assertTrue(MessagePage.getMessageOfLastMessage().contains(Message));

    }

    @AfterMethod
    public void afterEachTest(){
        WebDriverManager.closeBrowser();
    }
}

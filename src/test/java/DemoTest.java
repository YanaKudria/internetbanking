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

    HomePage homePage = new HomePage();
    MessagePage messagePage = new MessagePage();
    CurrencyPage currencyPage = new CurrencyPage();
    AccountsPage accountsPage = new AccountsPage();


    @BeforeMethod
    public void BeforeEachTest(){
        WebDriverManager.openBrowser();
    }

    @Test
    public void successDemoLoginTest() {
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        Assert.assertTrue(homePage.getUserName().equals("Королёва Ольга"));
}

    @Test
    public void makeSureThatBalanceIsPositive(){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        homePage.openAccountPage();
        Assert.assertTrue(accountsPage.makeSureThatBalanceIsPositive() > 0);
    }

    @Test
    public void checkIfTheMessageWasSent(){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        homePage.clickMassageIcon();
        messagePage.sendNewMessage("How do I get an official account statement?");
        messagePage.openLastSentMessage();
        Assert.assertTrue(messagePage.getMessageOfLastMessage().contains("How do I get an official account statement?"));
    }

    @Test
    public void makeSureCurrencyExchangeWasSuccessful(){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        homePage.openExchangePage();
        currencyPage.makeExchange(currencyPage.USD, currencyPage.RUB, "100");
        Assert.assertTrue(currencyPage.successExchangeMessageIsPresent());

    }

    @Test(dataProvider = "getDataFromCSV", dataProviderClass = DataProviderClass.class)
    public void sendingFewMessages(String Message){
        SiteNavigator.openMainDemoPage().submitFormWithCredentials("demo", "demo");
        homePage.clickMassageIcon();
        messagePage.sendNewMessage(Message);
        messagePage.openLastSentMessage();
        Assert.assertTrue(messagePage.getMessageOfLastMessage().contains(Message));

    }

    @AfterMethod
    public void afterEachTest(){
        WebDriverManager.closeBrowser();
    }
}

package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CurrencyPage extends Utils {

    private String amountField = "from-amount";
    private String calculateButton = "forward";
    private String confirmButton = "confirm";
    private String confirmationFrame = "confirmation-frame";
    private String successExchangeMessageField = "alert-success";

    public String USD = "10013";
    public String RUB = "10002";
    public String EUR = "10006";


    public void chooseAccountToDebit(String currency){
        Select drpDollarAccount = new Select(driver.findElement(By.id("acc1")));
        drpDollarAccount.selectByValue(currency);
    }

    public void chooseAccountToCredit(String currency){
        Select drpDollarAccount = new Select(driver.findElement(By.id("acc2")));
        drpDollarAccount.selectByValue(currency);
    }

    public void clickCalculateButton(){
        driver.findElement(By.id(calculateButton)).click();
    }

    public void clickConfirmButton(){
        Utils.waitForElementPresent(By.id(confirmButton));
        driver.findElement(By.id(confirmButton)).click();
    }

    public void setValueForExchange(String value){
        driver.findElement(By.id(amountField)).sendKeys(value);
    }

    public void makeExchange(String from, String to, String amount){
        chooseAccountToDebit(from);
        chooseAccountToCredit(to);
        setValueForExchange(amount);
        clickCalculateButton();
        driver.switchTo().frame(confirmationFrame);
        clickConfirmButton();
    }

    public boolean successExchangeMessageIsPresent(){
        String textFromMessage = driver.findElement(By.className(successExchangeMessageField)).getText();
        if(textFromMessage.equals("Перевод выполнен!")){
            return true;
        } else {
            return false;
        }
    }
}

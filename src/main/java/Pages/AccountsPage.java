package Pages;

import Utils.Utils;
import Utils.WebDriverManager;
import org.openqa.selenium.By;

public class AccountsPage extends Utils {


    private static String closingBalanceRow = "tr#closing-balance-row th:nth-of-type(2)";

    public static int makeSureThatBalanceIsPositive(){
        waitForElementPresent(By.cssSelector(closingBalanceRow));
        String amountvalue = driver.findElement(By.cssSelector(closingBalanceRow)).getText().substring(0,1);
        int amount = Integer.parseInt(amountvalue);
        return amount;
    }
}
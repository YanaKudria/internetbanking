package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Utils{


    private String userNameField = "span[class = \"filter-option pull-left\"]";
    private String buttonAccounts = "accounts-index";
    private String buttonStatement = "statements-statement";
    private String buttonMassage = "icon-email";

    public String getUserName(){
        return driver.findElement(By.cssSelector(userNameField)).getText();
    }

    public void openAccountPage(){
        Actions action = new Actions(driver);
      WebElement elem = driver.findElement(By.id(buttonAccounts));
      action.moveToElement(elem).perform();
      driver.findElement(By.id(buttonStatement)).click();
    }

    public void clickMassageIcon(){
       Utils.waitForElementPresent(By.className(buttonMassage));
       driver.findElement(By.className(buttonMassage)).click();
    }

    public void openExchangePage(){
        driver.get("https://idemo.bspb.ru/currency/exchange");
    }
}



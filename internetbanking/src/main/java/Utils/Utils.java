package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.By.id;

public class Utils extends WebDriverManager {

    public static void waitForElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithJS(String locator){

            WebElement element = driver.findElement(id(locator));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);

            element = driver.findElement(By.cssSelector(locator));
            executor.executeScript("arguments[0].click();", element);

            element = driver.findElement(By.className(locator));
            executor.executeScript("arguments[0].click();", element);

            element = driver.findElement(By.linkText(locator));
            executor.executeScript("arguments[0].click();", element);

            element = driver.findElement(By.xpath(locator));
            executor.executeScript("arguments[0].click();", element);
        }
}





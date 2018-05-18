package Pages;

import Utils.InitPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdemoMainPage extends InitPageElements {

    @FindBy(css = "input[name=username]")
    private WebElement loginField;
    @FindBy(css = "input[name=password]")
    private WebElement passwordField;
    @FindBy(css = "button[id=login-button]")
    private WebElement buttonLogIn;
    @FindBy(css = "button[id = login-otp-button]")
    private WebElement buttonPhone;

    public void submitFormWithCredentials(String login, String password) {
        loginField.clear();
        passwordField.clear();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        buttonLogIn.click();
        buttonPhone.click();
    }
}
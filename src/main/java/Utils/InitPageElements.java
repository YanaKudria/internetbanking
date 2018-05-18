package Utils;

import org.openqa.selenium.support.PageFactory;

public class InitPageElements extends PageFactory {

    public InitPageElements(){
        initElements(WebDriverManager.driver,this);
    }
}

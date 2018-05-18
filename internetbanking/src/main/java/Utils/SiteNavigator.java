package Utils;

import Pages.IdemoMainPage;

public class SiteNavigator extends WebDriverManager {
    public static IdemoMainPage openMainDemoPage(){
        driver.get("https://idemo.bspb.ru/");
        return new IdemoMainPage();
    }
}

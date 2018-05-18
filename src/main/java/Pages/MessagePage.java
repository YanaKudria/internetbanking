package Pages;

import Utils.Utils;
import org.openqa.selenium.By;

public class MessagePage extends Utils {

    private static String newLetterButton = "new-message-btn";
    private static String enterNewMassage = "span6";
    private static String sendMassageButton = "send-button";
    private static String lastMessageInListOfMessages = "//tbody/tr[2]/td[4]/div/a";
    private static String textFromLastMessage = ".message-content";


     public static void sendNewMessage(String textToSend){
         Utils.waitForElementPresent(By.id(newLetterButton));
         driver.findElement(By.id(newLetterButton)).click();
         Utils.waitForElementPresent(By.className(enterNewMassage));
         driver.findElement(By.className(enterNewMassage)).sendKeys(textToSend);
         Utils.waitForElementPresent(By.id(sendMassageButton));
         driver.findElement(By.id(sendMassageButton)).click();
         Utils.waitForElementPresent(By.xpath(lastMessageInListOfMessages));
     }

     public static void openLastSentMessage(){
         Utils.waitForElementPresent(By.xpath(lastMessageInListOfMessages));
         driver.findElement(By.xpath(lastMessageInListOfMessages)).click();
     }

     public static String getMessageOfLastMessage(){
         Utils.waitForElementPresent(By.cssSelector(textFromLastMessage));
         String textFromSentMessage = driver.findElement(By.cssSelector(textFromLastMessage)).getText();
         return textFromSentMessage;
     }
}



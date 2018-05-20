package Pages;

import Utils.Utils;
import org.openqa.selenium.By;

public class MessagePage extends Utils {

    private String newLetterButton = "new-message-btn";
    private String enterNewMassage = "span6";
    private String sendMassageButton = "send-button";
    private String lastMessageInListOfMessages = "//tbody/tr[2]/td[4]/div/a";
    private String textFromLastMessage = ".message-content";


     public void sendNewMessage(String textToSend){
         Utils.waitForElementPresent(By.id(newLetterButton));
         driver.findElement(By.id(newLetterButton)).click();
         Utils.waitForElementPresent(By.className(enterNewMassage));
         driver.findElement(By.className(enterNewMassage)).sendKeys(textToSend);
         Utils.waitForElementPresent(By.id(sendMassageButton));
         driver.findElement(By.id(sendMassageButton)).click();
         Utils.waitForElementPresent(By.xpath(lastMessageInListOfMessages));
     }

     public void openLastSentMessage(){
         Utils.waitForElementPresent(By.xpath(lastMessageInListOfMessages));
         driver.findElement(By.xpath(lastMessageInListOfMessages)).click();
     }

     public String getMessageOfLastMessage(){
         Utils.waitForElementPresent(By.cssSelector(textFromLastMessage));
         String textFromSentMessage = driver.findElement(By.cssSelector(textFromLastMessage)).getText();
         return textFromSentMessage;
     }
}



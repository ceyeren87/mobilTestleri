import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Login extends BasePage {

    public Login(AppiumDriver driver) {
        super(driver);
    }

    //Random Pop up Close
    public void closeGiveawayPopup() throws Exception {
        try {
            Thread.sleep(6000);
            List<WebElement> elements = driver.findElements(By.xpath("//android.view.View[@content-desc=\"İlgilenmiyorum\"]"));
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    element.click();
                }
            }
        } catch (Exception e) {
            throw (e);
        }
    }

    private By tanitimiGec = By.xpath("//android.view.View[@content-desc=\"Tanıtımı Geç\"]");
    private By musteriNo = By.xpath("//android.widget.EditText[@content-desc=\"Müşteri Numarası Veya TC Kimlik Numarası\"]");
    private By musteriClick = By.xpath("//android.widget.EditText[@content-desc=\"Müşteri Numarası Veya TC Kimlik Numarası\"]");
    //private By musteriClick = By.xpath("//android.view.View[@content-desc=\"Müşteri / T.C. Kimlik Numarası\"]");
    private By sifreClick = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]");
    private By girisOtp = By.xpath("//android.widget.EditText[@content-desc=\"SMS Doğrulama Kodu\"]");
    private By girisOtpClick = By.xpath("//android.view.View[@content-desc=\"Telefon Numarası\"]");
    private By girisGonderBtn = By.xpath("//android.widget.Button[@content-desc=\"Gönder\"]");

    public void loginCase(String user) throws Exception {

        click(tanitimiGec);
        Thread.sleep(5000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(760,562).perform();
        sendKeys(musteriNo,user);
        click(sifreClick);
        //hideKeyBoard();
        Thread.sleep(3000);
        touchAction.press(670,1926).perform();
        touchAction.press(675,1791).perform();
        touchAction.press(680,1667).perform();
        touchAction.press(405,1932).perform();
        touchAction.press(410,1802).perform();
        touchAction.press(415,1667).perform();
        touchAction.press(0,0).perform();
        sendKeys(girisOtp,"123456");
        click(girisOtpClick);
        click(girisGonderBtn);
        //Thread.sleep(10000);
        closeGiveawayPopup();

        //TouchAction action= new TouchAction(driver);
        //action.press(271, 642).release().perform();

        //TouchAction touchAction=new TouchAction(driver);
        //touchAction.tap(672,1550).perform();
        //touchAction.tap(672,1405).perform();
        //touchAction.tap(672,1256).perform();
        //touchAction.tap(408,1550).perform();
        //touchAction.tap(408,1396).perform();
        //touchAction.tap(408,1247).perform();


    }
}

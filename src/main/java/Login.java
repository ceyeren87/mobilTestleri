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

public class Login extends BasePage {

    public void hideKeyBoard()
    {
        try{driver.hideKeyboard();}
        catch(Exception e){}
    }

    public Login(AppiumDriver driver) {
        super(driver);
    }

    private By tanitimiGec = By.xpath("//android.view.View[@content-desc=\"Tanıtımı Geç\"]");
    private By musteriNo = By.xpath("//android.widget.EditText[@content-desc=\"Müşteri Numarası Veya TC Kimlik Numarası\"]");
    private By musteriClick = By.xpath("//android.widget.EditText[@content-desc=\"Müşteri Numarası Veya TC Kimlik Numarası\"]");
    //private By musteriClick = By.xpath("//android.view.View[@content-desc=\"Müşteri / T.C. Kimlik Numarası\"]");
    private By sifreClick = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]");
    private By girisOtp = By.xpath("//android.widget.EditText[@content-desc=\"SMS Doğrulama Kodu\"]");
    private By girisOtpClick = By.xpath("//android.view.View[@content-desc=\"Telefon Numarası\"]");
    private By girisGonderBtn = By.xpath("//android.widget.Button[@content-desc=\"Gönder\"]");
    private By popUpClose = By.xpath("//android.view.ViewGroup[@content-desc=\"errorModalClose\"]/android.widget.ImageView");

    public void loginCase(String user) throws InterruptedException, AWTException {

        click(tanitimiGec);
        Thread.sleep(5000);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(760,562).perform();
        sendKeys(musteriNo,user);
        click(sifreClick);
        //hideKeyBoard();
        Thread.sleep(3000);
        touchAction.tap(670,1926).perform();
        touchAction.tap(675,1791).perform();
        touchAction.tap(680,1667).perform();
        touchAction.tap(405,1932).perform();
        touchAction.tap(410,1802).perform();
        touchAction.tap(415,1667).perform();
        sendKeys(girisOtp,"123456");
        click(girisOtpClick);
        click(girisGonderBtn);

        if (popUp(popUpClose)){
            click(popUpClose);
        }

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

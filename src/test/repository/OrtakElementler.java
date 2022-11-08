import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OrtakElementler extends BasePage {

    private By islemler = By.xpath("//android.view.View[@content-desc=\"İşlemler\"]");


    public OrtakElementler(AppiumDriver driver) {
        super(driver);
    }



}

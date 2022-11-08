import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BasePage {

    private By loginDogrula = By.xpath("//android.view.View[@content-desc=\"Ana Sayfa\"]");


    public LoginTest(AppiumDriver driver) {
        super(driver);
    }

    public void loginTest() throws Exception {

        assertText(loginDogrula,"Ana Sayfa");

    }
}

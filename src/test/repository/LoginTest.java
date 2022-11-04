import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BasePage {

    private By loginDogrula = By.xpath("//android.view.View[@content-desc=\"Ana Sayfa\"]");


    public LoginTest(AppiumDriver driver) {
        super(driver);
    }

    //Random Pop up
    public void closeGiveawayPopup() throws Exception {
        try {
            Thread.sleep(5000);
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

    public void loginTest() throws Exception {

        closeGiveawayPopup();

        assertText(loginDogrula,"Ana Sayfa");

    }
}

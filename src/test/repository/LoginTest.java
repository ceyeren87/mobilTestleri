import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginTest extends BasePage {

    private By loginDogrula = By.xpath("//android.view.View[@content-desc=\"Ana Sayfa\"]");


    public LoginTest(AppiumDriver driver) {
        super(driver);
    }

    public void loginTest(){
        
        assertText(loginDogrula,"Ana Sayfa");

    }
}

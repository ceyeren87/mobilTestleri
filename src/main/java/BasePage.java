import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {

    public WebDriverWait wait;
    public AppiumDriver driver;

    //Constructor
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 35);
    }

    void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    void sendKeys(By element, String txt) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(txt);
    }

    boolean popUp(By element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).isEnabled();
        return true;
    }



    void assertText(By element , String txt){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(),txt);
    }
}







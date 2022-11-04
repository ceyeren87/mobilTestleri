import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DeviceSetup {


    public static String newDate(){
        return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
    }

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "MI 8 Lite");
        cap.setCapability("udid","4fc414db");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion","10.0");
        cap.setCapability("appPackage", "com.fibabanka.Fibabanka.preprod");
        cap.setCapability("appActivity", "com.fibabanka.Fibabanka.preprod.MainActivitynormal");
        cap.setCapability("noReset","false");
        cap.setCapability("autoAcceptAlerts","false");
        cap.setCapability("autoGrantPermissions","true");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //cap.setCapability("appPackage", "com.fibabanka.mobile.sit");
        //cap.setCapability("appActivity", "com.fibabanka.mobile.sit.MainActivity");


    }


    @AfterMethod
    public void quit(ITestResult result) throws IOException {

        if(ITestResult.FAILURE==result.getStatus()){

            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./Screenshots/"+result.getMethod().getMethodName()+"-"+ newDate() +".png"));
            driver.quit();

        }else{
            driver.quit();
        }

    }






}


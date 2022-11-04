import org.testng.annotations.Test;

import java.awt.*;

public class LoginPassed extends DeviceSetup {

    @Test(priority = 1)
    public void loginPassed() throws AWTException, InterruptedException {
        Login login = new Login(driver);
        LoginTest loginRepository = new LoginTest(driver);

        login.loginCase("109905");

        loginRepository.loginTest();

    }
}

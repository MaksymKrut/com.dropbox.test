package Tests;

import Pages.LoginPage;
import Utilities.Common;
import Utilities.Driver;
import Utilities.GetCredentials;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */

public class LoginTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws Exception {
        Driver.driver = Driver.browser("firefox");
        loginPage = PageFactory.initElements(Driver.driver, LoginPage.class);
        Common.startUrlInBrowser("https://www.dropbox.com/login");
    }

    @Test
    public void testMain() throws Exception {

        GetCredentials getCredentials = new GetCredentials();
        String username = getCredentials.getPropertyValue("username");
        String password = getCredentials.getPropertyValue("password");
        loginPage.loginPageOpened();
        loginPage.loginToDropbox(username, password);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Driver.driver.quit();
    }
}

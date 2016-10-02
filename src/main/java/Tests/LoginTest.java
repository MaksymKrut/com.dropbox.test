/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */

package Tests;

import Pages.LoginPage;
import Utilities.Common;
import Utilities.Driver;
import Utilities.GetCredentials;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws Exception {
        Driver.driver = Driver.browser("firefox");
        Common.loadPageObjects();
        loginPage = Common.loginPage;
        Common.startUrlInBrowser("https://www.dropbox.com/login");
    }

    @Test
    public void loginTest() throws Exception {
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
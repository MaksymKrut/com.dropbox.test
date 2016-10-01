/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Common;
import Utilities.Driver;
import Utilities.GetCredentials;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class LogoutTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() throws Exception {
        Driver.driver = Driver.browser("firefox");
        loginPage = PageFactory.initElements(Driver.driver, LoginPage.class);
        homePage = PageFactory.initElements(Driver.driver, HomePage.class);
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
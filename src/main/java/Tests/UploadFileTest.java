/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Common;
import Utilities.Driver;
import org.testng.annotations.*;

public class UploadFileTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private LoginTest loginTestPage = new LoginTest();

    @BeforeClass
    public void setUp() throws Exception {
        loginTestPage.setUp();
        homePage = Common.homePage;
        loginPage = Common.loginPage;
    }

    @Test
    public void fileUploadTest() throws Exception {
        loginPage.loginPageOpened();
        loginTestPage.loginTest();
        homePage.homePageOpened();
        homePage.fileUploadDropbox();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Driver.driver.quit();
    }
}
package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */

public class LoginPage {

    HomePage homePage = new HomePage();

    @FindBy(className = "text-input-input")
    private WebElement loginEmailField = null;
    @FindBy(className = "password-input")
    private WebElement loginPasswordField = null;
    @FindBy(className = "login-button")
    private WebElement loginButton = null;

    public boolean loginPageOpened(){
        try {
            Assert.assertEquals(Driver.driver.getTitle(), "Login - Dropbox", "Title Dropbox was not found!");
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean loginToDropbox(String username, String password) throws IOException{

        try {
            loginEmailField.sendKeys(username);
            loginPasswordField.sendKeys(password);
            loginButton.click();
            homePage.homePageOpened();
        } catch (Exception e){
            return false;
        }

    return true;

    }

}
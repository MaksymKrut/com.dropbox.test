/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
package Pages;

import Utilities.Common;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class HomePage {

    private By userMenu = By.id("personal-nav-item");

    @FindBy(className = "avatar-wrapper")
    private WebElement userLogo = null;
    @FindBy(linkText = "Sign out")
    private WebElement signOut = null;

    public boolean homePageOpened(){
        try {
            Assert.assertEquals(Driver.driver.getTitle(), "Home - Dropbox", "Title Dropbox was not found!");
            System.out.println("\n\nHome page is opened!\n\n");
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean waitForHomePage(){
        try {
            Common.explicitWaitByLocator(userMenu, 30);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean logoutFromDropbox() throws IOException {

        try {
            Common.clickWhenElementReady(userLogo, 10);
            System.out.println("\n\nUser menu clicked!\n\n");
            Common.clickWhenElementReady(signOut, 10);
            System.out.println("\n\nSign out clicked!\n\n");
        } catch (Exception e){
            return false;
        }

        return true;

    }
}

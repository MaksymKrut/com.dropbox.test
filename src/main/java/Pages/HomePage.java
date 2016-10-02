/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
package Pages;

import Utilities.Common;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {

    private By userMenu = By.id("personal-nav-item");

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
}

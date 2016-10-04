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

    @FindBy(className = "global-actions__button-sprite")
    private WebElement fileUploadButton = null;

    @FindBy(className = "db-modal-box")
    private WebElement fileUploadModal = null;

    @FindBy(className = "basic-uploader-link")
    private WebElement basicUploadLink = null;

    @FindBy(name = "file")
    private WebElement fileUploadField = null;

    @FindBy(className = "sprite_web.s_web_s_check")
    private WebElement fileUploadedCheck = null;

    @FindBy(className = "dbmodal-button.c-btn.c-btn--secondary")
    private WebElement secondaryButton = null;
    @FindBy(className = "c-btn--primary")
    private WebElement primaryButton = null;

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

    public boolean waitForUploadModal(){
        try {
            Common.explicitWait(fileUploadModal, 30);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean fileUploadDropbox() throws IOException {

        try {
            Common.clickWhenElementReady(fileUploadButton, 10);
            System.out.println("\n\nUpload file clicked!\n\n");

            Common.clickWhenElementReady(basicUploadLink, 10);
            System.out.println("\n\nBasic Upload clicked!\n\n");

            Common.clickWhenElementReady(primaryButton, 10);
            System.out.println("\n\nUpload button clicked!\n\n");

            String path = Common.getAbsoluteResourceFilePath("test.pdf");

            Common.uploadFile(path);

            Common.sleep(20);

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

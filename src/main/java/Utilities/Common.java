/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
package Utilities;

import Pages.*;
import Tests.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Common {

    public static LoginPage loginPage;
    public static LoginTest loginTestPage;
    public static HomePage homePage;

    public static void loadPageObjects() {
        loginPage = PageFactory.initElements(Driver.driver, LoginPage.class);
        loginTestPage = PageFactory.initElements(Driver.driver, LoginTest.class);
        homePage = PageFactory.initElements(Driver.driver, HomePage.class);
    }

    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static void uploadFile(String fileLocation) {
        try {
            setClipboardData(fileLocation);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static String getAbsoluteResourceFilePath(String name) {

        File file = new File("src/main/resources/" + name);
        String absolutePath = file.getAbsolutePath();

        System.out.println("\n\nFile absolute path: " + absolutePath + "\n\n");

        return absolutePath;
    }

    public static void sleep(Integer time) throws InterruptedException {
        Thread.sleep(time * 1000);
        System.out.println("Thread execution was sleep for " + time + " seconds.");
    }

    public static WebDriverWait webDriverWait(Integer timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, timeout);
        return wait;
    }

    public static void implicitWait(Integer time) {
        Driver.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        System.out.println("Execution was postponed for " + time + " seconds.");
    }

    public static WebElement explicitWait(WebElement element, int timeout) {
        webDriverWait(timeout).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement explicitWaitByLocator(By locator, int timeout) {
        WebElement element = webDriverWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static void clickWhenReady(By locator, int timeout) {
        WebElement element = webDriverWait(timeout).until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void clickWhenElementReady(WebElement element, int timeout) {
        webDriverWait(timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static boolean startUrlInBrowser(String url) {
        try {
            Driver.driver.get(url);
            Driver.driver.manage().window().maximize();
            System.out.println("Browser launched successfully with URL " + url);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
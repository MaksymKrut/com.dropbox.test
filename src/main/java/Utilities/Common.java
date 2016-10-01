package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
public class Common {
    public static boolean implicitWait(long time) {
        try {
            Driver.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
            System.out.println("Execution was postponed for " + time + " seconds.");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static WebElement getWhenVisible(By locator, int timeout) {
        WebElement element;
        WebDriverWait wait = new WebDriverWait(Driver.driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static void clickWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static boolean startUrlInBrowser(String url) {
        try {
            Driver.driver.get(url);
            Driver.driver.manage().window().maximize();
            System.out.println("Browser launched successfully with URL "+url);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */
package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver driver = null;
    public static WebDriver browser(String browser) {
        try {
            if (browser.equalsIgnoreCase("firefox"))
            {
                driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("chrome"))
            {
                driver = new ChromeDriver();
            }
        } catch (Exception e) {
            return null;
        }
        return driver;
    }
}
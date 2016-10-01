package Pages;

import Utilities.Common;
import org.openqa.selenium.By;

/**
 * Created by Maksym Krutskykh on 30-Sep-16.
 */

public class HomePage {

    By userMenu = By.id("personal-nav-item");

    public boolean homePageOpened(){
        try {
            Common.getWhenVisible(userMenu, 30);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}

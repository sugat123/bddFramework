package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtil {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String browser = "chrome";

    public static String login_url = "";

    public void waitAndClickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void waitElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sendKeysToElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}

package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseUtil {

    // Locators

    @FindBy(xpath = "") WebElement element;



    public Login(WebDriver driver) {
        BaseUtil.driver = driver;
        wait = new WebDriverWait(driver, 12);
        PageFactory.initElements(driver,this);
    }

    public void visitSite() {
        driver.get(login_url);
    }
}

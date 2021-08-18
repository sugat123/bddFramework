package Steps;

import Base.BaseUtil;
import Utility.LogMgr;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    private WebDriver createChromeDriver(){
        try {
            LogMgr.info(String.format("Launching browser %s", browser));
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("headless");
//            options.addArguments("window-size=1920x1080");
            return new ChromeDriver(options);
        } catch (Exception e) {
            LogMgr.info(String.format("Cannot start the %s browser", browser));
            return null;
        }
    }

    private WebDriver createFirefoxDriver(){
        try {
            LogMgr.info(String.format("Launching browser %s", browser));
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("headless");
//            options.addArguments("window-size=1400x600");
            return new FirefoxDriver(options);
        } catch (Exception e) {
            LogMgr.info(String.format("Cannot start the %s browser", browser));
            return null;
        }
    }

    @Before
    public void setUp(Scenario scenario) {
        LogMgr.info(String.format("Starting the automated test for the scenario '%s'", scenario.getName()));
//        BaseUtil.browser = System.getProperty("browser");
        if (BaseUtil.browser.equalsIgnoreCase("chrome")) {
            driver = createChromeDriver();
        }
        else if (BaseUtil.browser.equalsIgnoreCase("firefox")){
            driver = createFirefoxDriver();
        }
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        LogMgr.info("The automated test is complete and now closing the test.");
        if(scenario.isFailed()){
            String status = String.format("%s failed", scenario.getName());
            LogMgr.info(status);
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png"); // for cucumber-reporting
        }
        else if(scenario.getStatus().equalsIgnoreCase("passed")) {
            LogMgr.info(String.format("The scenario '%s' passed", scenario.getName()));
        }
        //Close browser and end the session
        driver.quit();
    }
}

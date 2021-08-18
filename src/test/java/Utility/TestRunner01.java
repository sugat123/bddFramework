package Utility;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Steps",
        tags = "",
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}
)

public class TestRunner01 extends AbstractTestNGCucumberTests{
}

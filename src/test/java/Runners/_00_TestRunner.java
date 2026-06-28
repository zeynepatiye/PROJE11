package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/java/FeatureFiles/_01_UserRegistration.feature",
                "src/test/java/FeatureFiles/_02_UserLogin.feature",
                "src/test/java/FeatureFiles/_03_PayBillFunctionality.feature",
                "src/test/java/FeatureFiles/_04_ContactInformationUpdate.feature",
                "src/test/java/FeatureFiles/_05_InterAccountMoneyTransfer.feature"

        },
        glue = {"StepDefinitions"}
)
public class _00_TestRunner extends AbstractTestNGCucumberTests {
}

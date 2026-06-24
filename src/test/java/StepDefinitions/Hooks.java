package StepDefinitions;

import Utility.ExcelUtilities;
import Utility.GWD;
import Utility.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After // after senaryo
    public void after(Scenario senaryo)
    {
        ExcelUtilities.writeToExcel(
                "src/test/java/ApahePOI/Resource/SenaryoSonuclari.xlsx",
                senaryo.getName(),
                senaryo.isFailed() ? "Failed" : "Passed"
        );

        if (senaryo.isFailed())
        {
            TakesScreenshot ts=((TakesScreenshot) GWD.getDriver());
            byte[] hafizadakiHali=ts.getScreenshotAs(OutputType.BYTES);
            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }

        GWD.quitDriver();
    }
}
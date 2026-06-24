package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    private static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    public static WebDriver getDriver () {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get() == null)
            threadBrowserName.set("chrome");
        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()) {
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                default:
                    threadDriver.set(new ChromeDriver());  // bu hatta bir driver set et
            }
            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return threadDriver.get();
    }

    public static void quitDriver ()
    {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        if (threadDriver.get() !=null){
            threadDriver.get().quit();

            WebDriver driver;
            driver=null;
            threadDriver.set(driver);
        }
    }

    public static void setThreadBrowserName(String browserName){threadBrowserName.set(browserName);}



}

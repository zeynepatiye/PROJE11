package Pages;

import Utility.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {
    // ortak fonksiyonlar burada bulunuyor
    public WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));

    public ParentPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    public void mySendKeys(WebElement e, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(e));
        scrollToElement(e);
        e.clear();
        e.sendKeys(text);
    }

    public void myClick(WebElement e)
    {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        scrollToElement(e);
        e.click();
    }

    public void scrollToElement(WebElement e){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", e);
    }

}

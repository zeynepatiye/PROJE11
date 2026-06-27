package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatePage extends ParentPage
{
    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerPage;

    @FindBy(css="a[href='billpay.htm']")
    public WebElement billPayPage;

    @FindBy (xpath = "//*[@id='leftPanel']/ul/li[6]/a")
    public WebElement updateContactInfo;

    @FindBy (linkText = "Open New Account")
    public WebElement openNewAccount ;

    @FindBy (linkText = "Transfer Funds")
    public WebElement transferFunds ;



}


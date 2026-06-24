package Pages;

import Utility.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DialogPage extends ParentPage{

    @FindBy(id = "customer.firstName")
    public WebElement firstname;

    @FindBy(id = "customer.lastName")
    public WebElement lastname;

    @FindBy(id = "customer.address.street")
    public WebElement address;

    @FindBy(id="customer.address.city")
    public WebElement city;

    @FindBy(id="customer.address.state")
    public WebElement state;

    @FindBy(id="customer.address.zipCode")
    public WebElement zipcode;

    @FindBy(id="customer.phoneNumber")
    public WebElement phone;

    @FindBy(id="customer.ssn")
    public WebElement ssn;

    @FindBy(id="customer.username")
    public WebElement registerUsername;

    @FindBy(id="customer.password")
    public WebElement registerPassword;

    @FindBy(id="repeatedPassword")
    public WebElement confirmPassword;

    @FindBy(xpath="//input[@type='submit' and @value='Register']")
    public WebElement btnRegister;

    @FindBy (css = "[id=rightPanel]>p")
    public  WebElement registerAssert;

//    @FindBy(xpath="//input[@type='text' and @name='username']")
//    public WebElement loginUsername;
//
//    @FindBy(xpath="//input[@type='password' and @name='password']")
//    public WebElement loginPassword;
//
//    @FindBy(xpath="//input[@type='submit' and @value='Log In']")
//    public WebElement btnLogin;

//    @FindBy(xpath = "//p[@class='error']")
//    public WebElement errorMessage;

    @FindBy (id = "customer.username.errors")
    public  WebElement usernamRequired;

    @FindBy(id="customer.password.errors")
    public WebElement passwordRequired;

    @FindBy(css="a[href='logout.htm']")
    public WebElement logout;

    @FindBy(name = "payee.name")
    public WebElement payeeName;

    @FindBy(name = "payee.address.street")
    public WebElement payeeAddress;

    @FindBy(name = "payee.address.city")
    public WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    public WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    public WebElement payeeZip;

    @FindBy(name = "payee.phoneNumber")
    public WebElement payeePhone;

    @FindBy(name = "payee.accountNumber")
    public WebElement accountNumber;

    @FindBy(name = "verifyAccount")
    public WebElement verifyAccountNumber;

    @FindBy(name = "amount")
    public WebElement amountInput;

    @FindBy(xpath = "//input[@value='Send Payment']")
    public WebElement sendPaymentButton;

    @FindBy(xpath = "//div[@id='billpayResult']/h1[@class='title']")
    public WebElement billPayCompleteTitle;

    @FindBy (xpath = "//*[@id='billpayResult']/h1")
    public WebElement billPayAssert ;

    @FindBy (xpath = "//*[@id='updateProfileForm']/form/table/tbody/tr[8]/td[2]/input")
    public WebElement updateProfileBtn;

    @FindBy(css="[id='updateProfileResult']>h1")
    public WebElement updateAssert;

    


}

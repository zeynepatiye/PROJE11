package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import Utility.GWD;
import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class _01_RegisterSteps {
    DialogPage dp = new DialogPage();
    NavigatePage np = new NavigatePage();
    @Given("The user navigates to the Para Bank home page")
    public void theUserNavigatesToTheParaBankHomePage() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        np.myClick(np.registerPage);
    }
    public String userName;
    @When("The user fills out the registration form with valid details")
    public void theUserFillsOutTheRegistrationFormWithValidDetails() {
        Faker randomUreteci = new Faker();
        userName = randomUreteci.name().firstName();
        dp.mySendKeys(dp.firstname, "Test");
        dp.mySendKeys(dp.lastname, "Tester");
        dp.mySendKeys(dp.address, "test sokak");
        dp.mySendKeys(dp.city, "istanbul");
        dp.mySendKeys(dp.state, "turkiye");
        dp.mySendKeys(dp.zipcode, "10011");
        dp.mySendKeys(dp.phone, "55555555");
        dp.mySendKeys(dp.ssn, "555");
        dp.mySendKeys(dp.registerUsername, userName);
        dp.mySendKeys(dp.registerPassword, "123456test");
        dp.mySendKeys(dp.confirmPassword, "123456test");
    }

    @And("The user clicks on the REGISTER button")
    public void theUserClicksOnTheREGISTERButton() {
        {
            dp.myClick(dp.btnRegister);
        }
    }

    @Then("The user should see the success message {string}")
    public void theUserShouldSeeTheSuccessMessage(String arg0) {
        String regisAssert=dp.registerAssert.getText();
        Assert.assertEquals(regisAssert, "Your account was created successfully. You are now logged in.", "Hatalı register girişimi.");
    }
}

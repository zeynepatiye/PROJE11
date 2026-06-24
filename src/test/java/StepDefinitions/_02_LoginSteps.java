package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class _02_LoginSteps {
    DialogPage dp = new DialogPage();

    @Then("User should see logout.") // logout yazısı baza alındı.
    public void userShouldSeeLogout() {
        String logoutAssert = dp.logout.getText();
        Assert.assertEquals(logoutAssert, "Log Out", "Başarısız login!");
    }

    @When("User clicks Logout")
    public void userClicksLogout() {
        dp.myClick(dp.logout);

    }

    public String userName;

    @When("The user fills out the registration form with username {string} and password {string}")
    public void theUserFillsOutTheRegistrationFormWithUsernameAndPassword(String username, String password) {
        Faker randomUreteci = new Faker();
        userName = randomUreteci.name().firstName();

        dp.mySendKeys(dp.firstname, "Test");
        dp.mySendKeys(dp.lastname, "Tester");
        dp.mySendKeys(dp.address, "test sokak");
        dp.mySendKeys(dp.city, "Istanbul");
        dp.mySendKeys(dp.state, "Turkey");
        dp.mySendKeys(dp.zipcode, "10111");
        dp.mySendKeys(dp.phone, "555555555");
        dp.mySendKeys(dp.ssn, "555");

        // senario outline tablosundan gelen parametreler
        dp.mySendKeys(dp.registerUsername, username);
        dp.mySendKeys(dp.registerPassword, password);
    }

    @Then("User should see the error message {string}")
    public void userShouldSeeTheErrorMessage(String expectedMessage) {
        String actualMessage = "";

        if (expectedMessage.contains("Username")) {
            actualMessage = dp.usernamRequired.getText();
        } else if (expectedMessage.contains("Password")) {
            actualMessage = dp.passwordRequired.getText();
        }
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}




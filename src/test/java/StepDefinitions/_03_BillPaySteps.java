package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class _03_BillPaySteps {
    DialogPage dp = new DialogPage();
    NavigatePage np = new NavigatePage();

    @And("the user navigates to the {string} page")
    public void theUserNavigatesToThePage(String arg0) {
        np.myClick(np.billPayPage);
    }

    @When("the user pays the bill with details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserPaysTheBillWithDetails(String payeeName, String address, String city, String state,
                                              String zipCode, String phone, String account, String amount) {

        // Senaryo outline paramatreleri
        dp.mySendKeys(dp.payeeName, payeeName);
        dp.mySendKeys(dp.payeeAddress, address);
        dp.mySendKeys(dp.payeeCity, city);
        dp.mySendKeys(dp.payeeState, state);
        dp.mySendKeys(dp.payeeZip, zipCode);
        dp.mySendKeys(dp.payeePhone, phone);
        dp.mySendKeys(dp.accountNumber, account);
        dp.mySendKeys(dp.verifyAccountNumber, account);
        dp.mySendKeys(dp.amountInput, amount);
        dp.myClick(dp.sendPaymentButton);
    }


    @Then("the system should verify that the bill has been paid successfully with message {string}")
    public void theSystemShouldVerifyThatTheBillHasBeenPaidSuccessfullyWithMessage(String expectedMessage) {
        dp.wait.until(ExpectedConditions.visibilityOf(dp.billPayCompleteTitle));
        String completeMessage = dp.billPayCompleteTitle.getText();
        Assert.assertEquals(completeMessage, expectedMessage, "Bill Payment Uncompleted!");
    }
}


package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import Pages.ParentPage;
import Utility.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class _05_MoneyTransfer {
    DialogPage dp = new DialogPage();
    NavigatePage np = new NavigatePage();
    ParentPage pp=new ParentPage();

    @Given("User Navigates to Open New Account and Makes New Account")
    public void userNavigatesToOpenNewAccountAndMakesNewAccount() {
        dp.myClick(np.openNewAccount);
        dp.myClick(dp.openNewAccountBtn);
        pp.bekle(10);



    }


    @And("User navigates to Transfer Funds")
    public void userNavigatesToTransferFunds() {
        dp.myClick(np.transferFunds);

    }

    @And("User Transfers Money")
    public void userTransfersMoney() {
        dp.mySendKeys(dp.amountMoney, "100");
        dp.myClick(dp.selectAccount);
        dp.myClick(dp.selectAccount1);
        dp.myClick(dp.transferButton);
    }

    @Then("The user should see should see the transfer message {string}")
    public void theUserShouldSeeShouldSeeTheTransferMessage(String expectedMessage) {
        dp.wait.until(ExpectedConditions.visibilityOf(dp.transferComplete));
        String complete = dp.transferComplete.getText();
        Assert.assertEquals(complete, "Transfer Complete!", "Hatalı para transferi.");
    }
}




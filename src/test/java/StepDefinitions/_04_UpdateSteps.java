package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class _04_UpdateSteps {

    DialogPage dp = new DialogPage();
    NavigatePage np = new NavigatePage();

    @Given("User navigates to Update Contact Info")
    public void userNavigatesToUpdateContactInfo() {
        np.myClick(np.updateContactInfo);
    }

    @And("write username as Datatable")
    public void writeUsernameAsDatatable(DataTable firstNames) {
        // Gherkin'deki alt alta olan listeyi Java List'ine çeviriyoruz
        List<String> listUsers = firstNames.asList(String.class);

        for (String u : listUsers) {
            // Önemli: Yeni ismi yazmadan önce kutuda halihazırda yazan ismi siliyoruz
            dp.firstname.clear();

            // Sıradaki ismi input kutusuna gönderiyoruz
            dp.mySendKeys(dp.firstname, u);

            // Konsolda adımları izlemek için (İsteğe bağlı kalabilir)
            System.out.println("Yazılan İsim: " + u);
        }
    }

    @And("The user clicks on the Update button")
    public void theUserClicksOnTheUpdateButton() {
        dp.myClick(dp.updateProfileBtn);
    }

    @Then("The user should see the update message {string}")
    public void theUserShouldSeeTheUpdateMessage(String expectedMessage) {
        // Profil güncellendi yazısının ekrana gelmesini bekliyoruz
        dp.wait.until(ExpectedConditions.visibilityOf(dp.updateAssert));

        String completeMessage = dp.updateAssert.getText();

        // Tam eşitlik (assertEquals) bazen sitedeki ekstra boşluklardan dolayı hata verebilir.
        // contains kullanmak testi daha güvenli hale getirir.
        Assert.assertTrue(completeMessage.contains(expectedMessage),
                "HATA: Profil güncellenemedi veya başarı mesajı ekranda görünmedi!");
    }
}
package stepDefinitions.Candidates;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.pagesCandidates.HomeCandidatesPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class CandidateMainPageStepDef {

    HomeCandidatesPage homeCandidatesPage = new HomeCandidatesPage();

    @Given("User navigates to Main page")


    public void userNavigatesToMainPage() throws InterruptedException {

        homeCandidatesPage.goToMainPage();




    }


    @When("Verifies that the Login button is visible in the Headers section.")
    public void verifiesThatTheLoginButtonIsVisibleInTheHeadersSection() {
        ;
        homeCandidatesPage.loginButton.isDisplayed();
        homeCandidatesPage.loginButton.click();


    }

    @Then("Verifies being redirected to the login page.")
    public void verifiesBeingRedirectedToTheLoginPage() {

        Driver.get().getCurrentUrl().equals("https://stage-fe-k8s.jobwars.de/login");


    }

    @When("Clicks the Login button.")
    public void clicksTheLoginButton() throws InterruptedException {
        homeCandidatesPage.loginButtonClick();

    }


    @And("Enters a valid e-mail into the Email box.")
    public void entersAValidEMailIntoTheEmailBox() {
        homeCandidatesPage.enterEmail(ConfigurationReader.get("email"));
    }


    @When("Enters a valid password into the password box.")
    public void entersAValidPasswordIntoThePasswordBox() {
        homeCandidatesPage.enterPassword();
    }

    @And("Clicks the Log In button.")
    public void clicksTheLogInButton() {
        homeCandidatesPage.clickLoginButtonAfterEnter();


    }

    @Then("Verifies being on the dashboard page.")
    public void verifiesBeingOnTheDashboardPage() {
        Assert.assertEquals("https://stage-fe-k8s.jobwars.de/", Driver.get().getCurrentUrl());
    }

    @And("Enters an invalid e-mail or and invalid password into the relevant boxes.")
    public void entersAnInvalidEMailOrAndInvalidPasswordIntoTheRelevantBoxes() {
        homeCandidatesPage.enterEmail("abc");
    }

    @Then("Verifies that error messages appear.")
    public void verifiesThatErrorMessagesAppear() {
        Assert.assertEquals(homeCandidatesPage.errorMailMessage.getText(),"Please enter a valid email");
    }

    @And("Accepts Cookies")
    public void acceptsCookies() {
        homeCandidatesPage.acceptCookies.click();
    }
}
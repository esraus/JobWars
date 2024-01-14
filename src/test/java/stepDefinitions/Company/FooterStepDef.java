package stepDefinitions.Company;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.pageCompany.HomeCompanyPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtilities;

import static org.junit.Assert.*;

public class FooterStepDef {
    HomeCompanyPage companyPage=new HomeCompanyPage();

    @Given("Go to the {string} url")
    public void go_to_the_url(String url) {
        Driver.get().get(ConfigurationReader.get(url));
    }

    @When("To be login")
    public void to_be_login() {
        companyPage.login();
    }

    @Then("Enter {string} and {string} for to be login")
    public void enter_and_for_to_be_login(String email, String password) {
        companyPage.loginWithParams(email, password);
    }

    @When("Accept the cookies")
    public void acceptTheCookies() {
        if(companyPage.locateSpanText("Reject").isDisplayed()){
        companyPage.locateSpanText("Reject").click();
    }else{

        }
    }
    @And("Close the driver")
    public void closeTheDriver() {
        Driver.closeDriver();
    }

    @Then("Verify that footer elements {string} are displayed")
    public void verifyThatFooterElementsAreDisplayed(String footerElements) {
        assertTrue(companyPage.footerTexts(footerElements).isDisplayed());
    }

    @Then("Verify that you can access {string}")
    public void verifyThatYouCanAccess(String url) {
        assertEquals(Driver.get().getCurrentUrl(),url);
    }

    @Then("Click thats footer sociallinks {string} {string}")
    public void clickThatsFooterSociallinks(String media, String title) {
       companyPage.Sociallinks(media,title);
      }

    @When("Click the {string} link")
    public void clickTheLink(String link) {
        BrowserUtils.waitFor(1);
        companyPage.footerLinks(link);
       }
    @Then("Verify that url include that {string}")
    public void verifyThatUrlIncludeThat(String path) {
        assertTrue(Driver.get().getCurrentUrl().contains(path));
    }

    @When("Click the {string} link in the footer")
    public void clickTheLinkInTheFooter(String jobWars) {
        JSUtilities.scrollToBottom(Driver.get());
        companyPage.socialMediaLinks(jobWars).click();
    }

    @Then("Verify that you can go to home page")
    public void verifyThatYouCanGoToHomePage() {
        assertTrue(companyPage.socialMediaLinks("Navbar Logo").isDisplayed());
    }

    @When("Click the {string} link in the footer language")
    public void clickTheLinkInTheFooterLanguage(String language) {
        JSUtilities.scrollToBottom(Driver.get());
        companyPage.locateSpanText(language).click();

    }
    @Then("Verify that you can change the languahe and see {string} text")
    public void verifyThatYouCanChangeTheLanguaheAndSeeText(String text) {
        assertEquals( companyPage.footerTexts(text).getText(),text);
    }
    @Then("Verify that you can go to {string} page")
    public void verifyThatYouCanGoToPage(String title) {
        BrowserUtils.switchToWindow("Unstech");
        assertTrue(Driver.get().getTitle().contains(title));
    }

    @Then("Fill in the that gaps {string} {string} {string} {string}")
    public void fillInTheThatGaps(String namesurname, String email, String subject, String message) {

    }
    @Then("Click the send button")
    public void clickTheSendButton() {

    }
    @Then("Verify that you have this {string}")
    public void verifyThatYouHaveThis(String resultMessage) {
        BrowserUtils.waitFor(5);
    }
}

package pages.pageCompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtilities;

public class HomeCompanyPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailText;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordText;

    public WebElement locateSpanText(String text) {
        return Driver.get().findElement(By.xpath("//span[text()='" + text + "']"));
    }

    public WebElement footerTexts(String text) {
        return Driver.get().findElement(By.xpath("//*[text()='" + text + "']"));
    }

    public WebElement socialMediaLinks(String text) {
        return Driver.get().findElement(By.xpath("//*[@alt='" + text + "']"));
    }
    public void login() {
        footerTexts("Log In").click();
        emailText.sendKeys(ConfigurationReader.get("email"));
        passwordText.sendKeys(ConfigurationReader.get("password"));
        locateSpanText("Log In").click();
    }

    public void loginWithParams(String email, String password) {
        footerTexts("Log In").click();
        emailText.sendKeys(ConfigurationReader.get(email));
        passwordText.sendKeys(ConfigurationReader.get(password));
        locateSpanText("Log In").click();

    }
    public void Sociallinks(String media, String title) {
        if (media.equals("linkedin")) {
            socialMediaLinks(media).click();
            BrowserUtils.waitFor(2);
            BrowserUtils.switchToWindow(title);
            JSUtilities.scrollToElement(Driver.get(), locateSpanText("Reject all"));
            locateSpanText("Reject all").click();
            BrowserUtils.waitFor(1);
        } else {
            socialMediaLinks(media).click();
            BrowserUtils.waitFor(2);
            BrowserUtils.switchToWindow(title);
        }
    }
    public void footerLinks(String link) {
        BrowserUtils.waitFor(1);
        if(link.contains("About Us")){
            JSUtilities.scrollToBottom(Driver.get());
            BrowserUtils.waitForPresenceOfElement(By.xpath("(//*[text()='About Us'])[2]"),10);
            Driver.get().findElement(By.xpath("(//*[text()='About Us'])[2]")).click();
        }else{
            JSUtilities.scrollToBottom(Driver.get());
            BrowserUtils.waitForPresenceOfElement(By.xpath("(//*[text()='About Us'])[2]"),10);
            footerTexts(link).click();

        }
}}
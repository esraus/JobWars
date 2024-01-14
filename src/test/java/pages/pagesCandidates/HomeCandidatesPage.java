package pages.pagesCandidates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class HomeCandidatesPage extends BasePage {

    @FindBy(xpath = "(//div/ul/li)[4]")
    public WebElement loginButton;
    @FindBy(xpath = "//span[text()='Accept All']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//div/input[@placeholder='Email']")
    public WebElement eMail;
    @FindBy(xpath = "//div/input[@placeholder='Password']")
    public WebElement passWord;

    @FindBy(xpath = "//span[@class='p-button-label p-c']")
    public WebElement loginButtonAfter;
    @FindBy(xpath = "//div[text()='Please enter a valid email']")
    public WebElement errorMailMessage;



    public void goToMainPage() throws InterruptedException {

        WebDriver driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://stage-fe-k8s.jobwars.de/");
        Thread.sleep(5000);
    }

    public void loginButtonClick() throws InterruptedException {
        loginButton.click();
        Thread.sleep(3000);
    }
    public void enterEmail(String str) {
        eMail.sendKeys(str);
    }

    public void enterPassword() {
        passWord.sendKeys(ConfigurationReader.get("password"));
    }

    public void clickLoginButtonAfterEnter() {
        loginButtonAfter.click();
        BrowserUtils.waitFor(3);
    }
}
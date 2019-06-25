package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basepages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@id='spanMessage']")
    private WebElement warning;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage login(String userName, String password) {
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new DashboardPage(driver);
    }

    public LoginPage loginWithIncorrectCredentials(String userName, String password) {
        if(userName != null) {
            userNameInput.sendKeys(userName);
        }

        if(password != null) {
            passwordInput.sendKeys(password);
        }

        loginButton.click();
        return this;
    }

    public String getDisplayedWarning() {
        return warning.getText();
    }
}
package pages.commonpageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basepages.BasePage;

public class WelcomeMenu extends BasePage {

    @FindBy(xpath = "//a[@id='welcome']")
    private WebElement welcomeButton;

    @FindBy(xpath = "//a[@href='/index.php/auth/logout']")
    private WebElement logoutButton;

    public WelcomeMenu(WebDriver driver) {
        super(driver);
    }

    public WelcomeMenu open() {
        welcomeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        return this;
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}
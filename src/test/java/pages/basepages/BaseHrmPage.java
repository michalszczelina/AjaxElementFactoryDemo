package pages.basepages;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.commonpageelements.WelcomeMenu;

public abstract class BaseHrmPage extends BasePage {

    protected WelcomeMenu welcomeMenu = new WelcomeMenu(driver);

    public BaseHrmPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        welcomeMenu
                .open()
                .clickLogoutButton();

        return new LoginPage(driver);
    }
}
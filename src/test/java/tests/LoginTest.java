package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    private final String USER_NAME = "Admin";
    private final String PASSWORD = "admin123";

    @BeforeEach
    public void beforeEachTest() {
        driver.get(loginPageUrl);
    }

    @DisplayName("Can login and logout")
    @Test
    public void canLogin() {
        String expectedUrlAfterLogout = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        String currentUrl = new LoginPage(driver)
                .login(USER_NAME, PASSWORD)
                .logout()
                .getCurrentUrl();

        assertEquals(expectedUrlAfterLogout, currentUrl);
    }

    @DisplayName("Cannot login with incorrect credentials")
    @ParameterizedTest
    @CsvFileSource(resources = "/LoginTestParameters.csv")
    public void cannotLoginWithIncorrectCredentials(String userName, String password, String expectedWarning) {
        String displayedWarning = new LoginPage(driver)
                .loginWithIncorrectCredentials(userName, password)
                .getDisplayedWarning();

        assertEquals(expectedWarning, displayedWarning);
    }
}
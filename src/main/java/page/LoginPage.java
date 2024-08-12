package page;

import io.appium.java_client.android.AndroidDriver;

/**
 * Represents the login page of the application and provides methods to interact with login-related UI elements.
 * This class extends from {@link BasePage} and includes methods to perform actions on the login page, such as
 * entering email and password, clicking the login button, and verifying error messages.
 *
 * @author Kent Van Lim
 */
public class LoginPage extends BasePage {

    /**
     * Enters the given email address into the email input field on the login page.
     *
     * @param driver   The {@link AndroidDriver} instance used to interact with the app.
     * @param keywords The email address to be entered.
     */
    public void sendEmailToLogin(AndroidDriver driver, String keywords) {
        waitAndThenEnterData(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textInputEditTextEmail", keywords);
    }

    /**
     * Enters the given password into the password input field on the login page.
     *
     * @param driver   The {@link AndroidDriver} instance used to interact with the app.
     * @param keywords The password to be entered.
     */
    public void sendPasswordToLogin(AndroidDriver driver, String keywords) {
        waitAndThenEnterData(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textInputEditTextPassword", keywords);
    }

    /**
     * Clicks the login button on the login page.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     */
    public void buttonLogin(AndroidDriver driver) {
        waitAndThenClick(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/appCompatButtonLogin");
    }

    /**
     * Checks if the error message for login is present on the screen.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @return {@code true} if the error message is present, {@code false} otherwise.
     */
    public Boolean getErrorMessageLogin(AndroidDriver driver) {
        return validateElementPresent(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/snackbar_text");
    }

    /**
     * Checks if the error message for an invalid email format is present on the screen.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @return {@code true} if the invalid email format error message is present, {@code false} otherwise.
     */
    public Boolean getErrorMessageInvalidEmailFormat(AndroidDriver driver) {
        return validateElementPresent(driver, BasePage.ByLocator.XPATH,
                "//android.widget.TextView[@text='Enter Valid Email']");
    }

    /**
     * Verifies if the account details are displayed after a successful login.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @return {@code true} if the account details are visible, {@code false} otherwise.
     */
    public Boolean verifyAccountAfterLogin(AndroidDriver driver) {
        return validateElementPresent(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textViewEmail");
    }
}
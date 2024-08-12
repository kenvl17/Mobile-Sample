package page;

import io.appium.java_client.android.AndroidDriver;

/**
 * Represents the registration page of the application and provides methods to interact with registration-related UI elements.
 * This class extends from {@link BasePage} and includes methods to perform actions on the registration page, such as
 * entering personal details, clicking buttons, and validating error messages.
 *
 * @author Kent Van Lim
 */
public class RegisterPage extends BasePage {

    /**
     * Clicks the register link on the registration page.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     */
    public void clickRegister(AndroidDriver driver) {
        waitAndThenClick(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textViewLinkRegister");
    }

    /**
     * Enters the given name into the name input field on the registration page.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @param name   The name to be entered.
     */
    public void inputName(AndroidDriver driver, String name) {
        waitAndThenEnterData(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textInputEditTextName", name);
    }

    /**
     * Enters the given email address into the email input field on the registration page.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @param email  The email address to be entered.
     */
    public void inputEmail(AndroidDriver driver, String email) {
        waitAndThenEnterData(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textInputEditTextEmail", email);
    }

    /**
     * Checks if a specific error message is present on the screen.
     *
     * @param driver   The {@link AndroidDriver} instance used to interact with the app.
     * @param keywords The text of the error message to check.
     * @return {@code true} if the error message is present, {@code false} otherwise.
     */
    public Boolean getErrorMessageFieldGlobal(AndroidDriver driver, String keywords) {
        return validateElementPresent(driver, BasePage.ByLocator.XPATH,
                "//android.widget.TextView[@text='" + keywords + "']");
    }

    /**
     * Verifies if the login button is present on the registration page after a registration attempt.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @return {@code true} if the login button is present, {@code false} otherwise.
     */
    public Boolean validateLoginButtonAfterRegister(AndroidDriver driver) {
        return validateElementPresent(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/appCompatButtonLogin");
    }

    /**
     * Enters the given password into the password input field on the registration page.
     *
     * @param driver   The {@link AndroidDriver} instance used to interact with the app.
     * @param password The password to be entered.
     */
    public void inputPassword(AndroidDriver driver, String password) {
        waitAndThenEnterData(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textInputEditTextPassword", password);
    }

    /**
     * Re-enters the given password into the confirm password input field on the registration page.
     *
     * @param driver            The {@link AndroidDriver} instance used to interact with the app.
     * @param reinputPassword   The password to be confirmed.
     */
    public void reinputPassword(AndroidDriver driver, String reinputPassword) {
        waitAndThenEnterData(driver, BasePage.ByLocator.ID,
                "com.loginmodule.learning:id/textInputEditTextConfirmPassword", reinputPassword);
    }

    /**
     * Clicks the register button on the registration page.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     */
    public void clickButtonRegister(AndroidDriver driver) {
        waitAndThenClick(driver, BasePage.ByLocator.XPATH,
                "//android.widget.Button[@resource-id='com.loginmodule.learning:id/appCompatButtonRegister']");
    }

    /**
     * Checks if the error message for an invalid email is present on the screen.
     *
     * @param driver The {@link AndroidDriver} instance used to interact with the app.
     * @return {@code true} if the invalid email error message is present, {@code false} otherwise.
     */
    public Boolean validateErrorInvalidEmail(AndroidDriver driver) {
        return validateElementPresent(driver, BasePage.ByLocator.UISELECTOR,
                ".text(\"Enter Valid Email\")");
    }
}

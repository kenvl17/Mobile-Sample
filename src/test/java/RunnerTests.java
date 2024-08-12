import io.github.cdimascio.dotenv.Dotenv;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.RegisterPage;
import setup.TestSetup;


/**
 * Contains test cases for login and registration functionalities.
 * Extends {@link TestSetup} to initialize and manage the Appium test environment.
 * Uses TestNG annotations for setting up, executing, and tearing down tests.
 */
public class RunnerTests extends TestSetup {

    /** Dotenv instance for loading environment variables. */
    private final Dotenv dotenv = Dotenv.configure().load();

    /** Page object for login functionality. */
    private LoginPage log;

    /** Page object for registration functionality. */
    private RegisterPage reg;

    /** Valid email for login and registration tests. */
    protected String validEmail = dotenv.get("VALID_EMAIL");

    /** Valid password for login and registration tests. */
    protected String validPassword = dotenv.get("VALID_PASSWORD");

    /** Invalid email format for testing email validation. */
    protected String invalidEmailFormat = dotenv.get("INVALID_EMAIL_FORMAT");

    /** Incorrect email for login tests. */
    protected String incorrectEmail = dotenv.get("INCORRECT_EMAIL");

    /** Name for registration tests. */
    protected String name = dotenv.get("NAME");

    /** Invalid reinput password for testing password confirmation. */
    protected String invalidReinputPassword = dotenv.get("INVALID_REINPUT_PASSWORD");

    /** Randomly generated string for testing unique email registration. */
    private final String randomString = generateRandomString(3);

    /**
     * Initializes the test setup and page objects before each test method.
     */
    @BeforeMethod
    public void init() {
        setup();
        log = new LoginPage();
        reg = new RegisterPage();
    }

    /**
     * Tests login with valid email and password.
     */
    @Test
    public void testLoginWithValidData() {
        log.sendEmailToLogin(driver, validEmail);
        log.sendPasswordToLogin(driver, validPassword);
        log.buttonLogin(driver);
        Assert.assertTrue(log.verifyAccountAfterLogin(driver));
    }

    /**
     * Tests login with incorrect email and valid password.
     */
    @Test
    public void testLoginWithInvalidData() {
        log.sendEmailToLogin(driver, incorrectEmail);
        log.sendPasswordToLogin(driver, validPassword);
        log.buttonLogin(driver);
        Assert.assertTrue(log.getErrorMessageLogin(driver));
    }

    /**
     * Tests login with invalid email format and valid password.
     */
    @Test
    public void testLoginWithInvalidFormatEmail() {
        log.sendEmailToLogin(driver, invalidEmailFormat);
        log.sendPasswordToLogin(driver, validPassword);
        log.buttonLogin(driver);
        Assert.assertTrue(log.getErrorMessageInvalidEmailFormat(driver));
    }

    /**
     * Tests registration with incorrect reinput password.
     */
    @Test
    public void invalidRegisterWrongReinputPassword() {
        reg.clickRegister(driver);
        reg.inputEmail(driver, validEmail);
        reg.inputName(driver, name);
        reg.inputPassword(driver, validPassword);
        reg.reinputPassword(driver, invalidReinputPassword);
        reg.clickButtonRegister(driver);
        Assert.assertTrue(reg.getErrorMessageFieldGlobal(driver, "Password Does Not Matches"));
    }

    /**
     * Tests registration with blank fields.
     */
    @Test
    public void invalidRegisterBlankField() {
        reg.clickRegister(driver);
        reg.clickButtonRegister(driver);
        Assert.assertTrue(reg.getErrorMessageFieldGlobal(driver, "Enter Full Name"));
    }

    /**
     * Tests registration with a duplicate email address.
     */
    @Test
    public void invalidRegisterDuplicateEmail() {
        reg.clickRegister(driver);
        reg.inputEmail(driver, validEmail);
        reg.inputName(driver, name);
        reg.inputPassword(driver, validPassword);
        reg.reinputPassword(driver, validPassword);
        reg.clickButtonRegister(driver);
        Assert.assertTrue(reg.getErrorMessageFieldGlobal(driver, "Email Already Exists"));
    }

    /**
     * Tests registration with valid data.
     */
    @Test
    public void registerWithValidData() {
        reg.clickRegister(driver);
        reg.inputEmail(driver, randomString + validEmail);
        reg.inputName(driver, name);
        reg.inputPassword(driver, validPassword);
        reg.reinputPassword(driver, validPassword);
        reg.clickButtonRegister(driver);
        Assert.assertTrue(reg.getErrorMessageFieldGlobal(driver, "Registration Successful"));
    }

    /**
     * Tests registration with an invalid email format and mismatched password confirmation.
     */
    @Test
    public void registerWithInvalidData() {
        reg.clickRegister(driver);
        reg.inputEmail(driver, invalidEmailFormat);
        reg.inputName(driver, name);
        reg.inputPassword(driver, validPassword);
        reg.reinputPassword(driver, invalidReinputPassword);
        reg.clickButtonRegister(driver);
        Assert.assertTrue(reg.validateErrorInvalidEmail(driver));
    }

    /**
     * Cleans up the test environment after each test method.
     */
    @AfterMethod
    public void cleanup() {
        tearDown();
    }
}

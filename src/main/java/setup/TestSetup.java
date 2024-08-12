package setup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Sets up and tears down the Appium test environment.
 */
public class TestSetup {

    /** The Appium AndroidDriver instance. */
    protected AndroidDriver<MobileElement> driver;

    /** Dotenv instance for loading environment variables. */
    protected final Dotenv dotenv = Dotenv.configure().load();

    /**
     * Initializes the Appium driver with desired capabilities.
     */
    public void setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", dotenv.get("DEVICE_NAME"));
        caps.setCapability("platformName", dotenv.get("PLATFORM_NAME"));
        caps.setCapability("appPackage", dotenv.get("APP_PACKAGE"));
        caps.setCapability("appActivity", dotenv.get("APP_ACTIVITY"));
        caps.setCapability("noReset", dotenv.get("NO_RESET"));

        try {
            driver = new AndroidDriver<MobileElement>(
                    new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Quits the Appium driver.
     */
    public static String generateRandomString(int length) {
        // Define the set of characters you want to use
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

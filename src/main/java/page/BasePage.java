package page;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Provides common methods for interacting with Android elements using Appium.
 * This class includes methods for entering data, retrieving text, validating element presence,
 * and clicking elements, all with wait conditions to ensure elements are visible before performing actions.
 */
public class BasePage {

    /**
     * Enum to specify different types of locators used for finding elements.
     */
    public enum ByLocator {
        XPATH, ID, UISELECTOR
    }

    /**
     * Waits for an element to be visible and then sends the specified data to it.
     *
     * @param driver   The AndroidDriver instance to interact with the app.
     * @param loc      The locator type to use (e.g., XPATH, ID, UISELECTOR).
     * @param locator  The locator value to find the element.
     * @param keywords The text to send to the element.
     */
    public static void waitAndThenEnterData(AndroidDriver<AndroidElement> driver, ByLocator loc, String locator, String keywords) {
        try {
            switch (loc) {
                case XPATH:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    elementXpath.sendKeys(keywords);
                    break;
                case ID:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    elementId.sendKeys(keywords);
                    break;
                case UISELECTOR:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    elementUiAutomator.sendKeys(keywords);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for an element to be visible and then retrieves its text.
     *
     * @param driver   The AndroidDriver instance to interact with the app.
     * @param loc      The locator type to use (e.g., XPATH, ID, UISELECTOR).
     * @param locator  The locator value to find the element.
     * @return The text of the element, or an empty string if the element is not found.
     */
    public static String waitAndThenGetText(AndroidDriver<AndroidElement> driver, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case XPATH:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    return elementXpath.getText();
                case ID:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    return elementId.getText();
                case UISELECTOR:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    return elementUiAutomator.getText();
                default:
                    return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Waits for an element to be visible and checks if it is displayed.
     *
     * @param driver   The AndroidDriver instance to interact with the app.
     * @param loc      The locator type to use (e.g., XPATH, ID, UISELECTOR).
     * @param locator  The locator value to find the element.
     * @return {@code true} if the element is displayed; {@code false} otherwise.
     */
    public static boolean validateElementPresent(AndroidDriver<AndroidElement> driver, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case XPATH:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    return elementXpath.isDisplayed();
                case ID:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    return elementId.isDisplayed();
                case UISELECTOR:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    return elementUiAutomator.isDisplayed();
                default:
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Generates a random alphanumeric string of the specified length.
     *
     * @param length The length of the random string to generate.
     * @return A random alphanumeric string.
     */


    /**
     * Waits for an element to be visible and then clicks it.
     *
     * @param driver   The AndroidDriver instance to interact with the app.
     * @param loc      The locator type to use (e.g., XPATH, ID, UISELECTOR).
     * @param locator  The locator value to find the element.
     */
    public static void waitAndThenClick(AndroidDriver<AndroidElement> driver, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case XPATH:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    elementXpath.click();
                    break;
                case ID:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    elementId.click();
                    break;
                case UISELECTOR:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    elementUiAutomator.click();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

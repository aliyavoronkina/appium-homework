package ru.netology.testing.uiautomator.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.*;

public class AppTests {

    private AndroidDriver driver;
    private MainPage mainPage;
    private NewActivityPage newActivityPage;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung");
        caps.setCapability("udid", "R5CY648GZEF");
        caps.setCapability("appPackage", "ru.netology.testing.uiautomator");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        mainPage = new MainPage(driver);
        newActivityPage = new NewActivityPage(driver);
    }

    @Test
    public void testEmptyString() {
        mainPage.clearInput();
        String textBefore = mainPage.getInputText();
        mainPage.clickChangeButton();
        String textAfter = mainPage.getInputText();
        assertEquals(textAfter, textBefore, "Текст не должен измениться при пустом поле");
    }

    @Test
    public void testOpenTextInNewActivity() {
        String testText = "Привет, Appium!";
        mainPage.enterText(testText);
        mainPage.clickActivityButton();
        String displayedText = newActivityPage.getDisplayedText();
        assertTrue(displayedText.contains(testText), "Текст в новой Activity должен содержать введенный текст");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
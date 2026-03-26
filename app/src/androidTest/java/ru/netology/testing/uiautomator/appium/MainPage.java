package ru.netology.testing.uiautomator.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {
    private AndroidDriver<?> driver;
    private WebDriverWait wait;

    private final By inputFieldLocator = By.id("ru.netology.testing.uiautomator:id/userInput");
    private final By changeButtonLocator = By.id("ru.netology.testing.uiautomator:id/buttonChange");
    private final By activityButtonLocator = By.id("ru.netology.testing.uiautomator:id/buttonActivity");

    public MainPage(AndroidDriver<?> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clearInput() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFieldLocator));
        driver.findElement(inputFieldLocator).clear();
    }

    public void enterText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFieldLocator));
        driver.findElement(inputFieldLocator).sendKeys(text);
    }

    public String getInputText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFieldLocator));
        return driver.findElement(inputFieldLocator).getText();
    }

    public void clickChangeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(changeButtonLocator));
        driver.findElement(changeButtonLocator).click();
    }

    public void clickActivityButton() {
        wait.until(ExpectedConditions.elementToBeClickable(activityButtonLocator));
        driver.findElement(activityButtonLocator).click();
    }
}
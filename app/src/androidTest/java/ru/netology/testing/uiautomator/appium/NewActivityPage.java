package ru.netology.testing.uiautomator.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NewActivityPage {
    private AndroidDriver<?> driver;
    private WebDriverWait wait;

    public NewActivityPage(AndroidDriver<?> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getDisplayedText() {
        // Ждем появления любого TextView
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.TextView")));

        // Находим все TextView на экране
        List<? extends WebElement> textViews = driver.findElements(By.className("android.widget.TextView"));

        System.out.println("Найдено TextView: " + textViews.size());

        // Выводим все тексты для отладки
        for (int i = 0; i < textViews.size(); i++) {
            System.out.println("TextView " + i + ": '" + textViews.get(i).getText() + "'");
        }

        // Ищем TextView, который содержит "Привет" или не равен "UiAutomator"
        for (WebElement tv : textViews) {
            String text = tv.getText();
            if (text != null && !text.isEmpty() && !text.equals("UiAutomator")) {
                return text;
            }
        }

        // Если не нашли, возвращаем текст последнего
        if (textViews.size() > 0) {
            return textViews.get(textViews.size() - 1).getText();
        }

        return "Текст не найден";
    }
}
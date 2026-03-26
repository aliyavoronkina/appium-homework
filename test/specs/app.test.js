describe('Тестирование Android приложения', () => {
    let driver;

    before(async () => {
        const { remote } = require('webdriverio');
        driver = await remote({
            capabilities: {
                platformName: 'Android',
                'appium:deviceName': 'Samsung',
                'appium:udid': 'R5CY648GZEF',
                'appium:appPackage': 'ru.netology.testing.uiautomator',
                'appium:appActivity': '.MainActivity',
                'appium:automationName': 'UiAutomator2',
                'appium:noReset': true
            },
            port: 4723,
            logLevel: 'info'
        });
    });

    it('Тест 1: Попытка установки пустой строки', async () => {
        console.log('=== Запуск теста 1 ===');
        
    const inputField = await driver.$('id=ru.netology.testing.uiautomator:id/userInput');
    const changeButton = await driver.$('id=ru.netology.testing.uiautomator:id/buttonChange');


        await inputField.clearValue();
        const textBefore = await inputField.getText();
        console.log('Текст в поле ДО нажатия:', textBefore);
        
        await changeButton.click();
        await driver.pause(1000);
        
        const textAfter = await inputField.getText();
        console.log('Текст в поле ПОСЛЕ нажатия:', textAfter);
        console.log('Тест 1 завершен');
    });

    it('Тест 2: Открытие текста в новой Activity', async () => {
    console.log('=== Запуск теста 2 ===');
    
    const inputField = await driver.$('id=ru.netology.testing.uiautomator:id/userInput');
    const activityButton = await driver.$('id=ru.netology.testing.uiautomator:id/buttonActivity');
    
    await inputField.clearValue();
    const testText = 'Привет, Appium!';
    await inputField.setValue(testText);
    console.log('Введен текст:', testText);
    
    await activityButton.click();
    await driver.pause(2000);
    
    const textView = await driver.$('android.widget.TextView');
    const displayedText = await textView.getText();
    console.log('Текст в новой Activity:', displayedText);
    
    if (displayedText.includes(testText)) {
        console.log('✅ Тест пройден! Текст совпадает');
    } else {
        console.log('❌ Тест не пройден! Текст не совпадает');
    }
    
    await driver.back();
    console.log('Тест 2 завершен');
});

    after(async () => {
        if (driver) {
            await driver.deleteSession();
            console.log('Сессия закрыта');
        }
    });
});

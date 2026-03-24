exports.config = {
    runner: 'local',
    specs: ['./test/specs/**/*.js'],
    capabilities: [{
        platformName: 'Android',
        'appium:deviceName': 'Samsung',
        'appium:udid': 'R5CY648GZEF',
        'appium:appPackage': 'ru.netology.testing.uiautomator',
        'appium:appActivity': '.MainActivity',
        'appium:automationName': 'UiAutomator2',
        'appium:noReset': true
    }],
    services: ['appium'],
    appium: {
        command: 'appium',
        logPath: './logs'
    },
    port: 4723,
    framework: 'mocha',
    mochaOpts: {
        ui: 'bdd',
        timeout: 60000
    },
    logLevel: 'info'
};

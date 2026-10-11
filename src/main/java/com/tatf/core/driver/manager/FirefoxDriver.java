package com.tatf.core.driver.manager;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriver extends DriverManager {
    /**
     * Crea el driver de Firefox con las opciones por defecto.
     */
    public FirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.setAcceptInsecureCerts(true);

        firefoxOptions.addPreference("signon.rememberSignons", false);
        firefoxOptions.addPreference("signon.autofillForms", false);
        firefoxOptions.addPreference("signon.generation.enabled", false);
        firefoxOptions.addPreference("signon.management.page.breach-alerts.enabled", false);

        this.driver = new org.openqa.selenium.firefox.FirefoxDriver(firefoxOptions);

        this.driver.manage().window().maximize();

        setDefaultConfig();
    }
}
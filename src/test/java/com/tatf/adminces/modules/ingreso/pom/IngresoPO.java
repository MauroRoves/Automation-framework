package com.tatf.adminces.modules.ingreso.pom;

import com.tatf.core.browser.IBrowser;

public class IngresoPO {
    private final IBrowser browser;

    private final String hashInput = "pass";
    private final String submitButton = "//button[@type='submit']";

    public IngresoPO(IBrowser browser) {
        this.browser = browser;
    }

    public void navigateTo(String url) {
        this.browser.interaction().navigateTo(url);
    }

    public void enterHash(String hash) {
        this.browser.find().id(hashInput).write(hash);
    }

    public void submit() {
        this.browser.find().xpath(submitButton).click();
    }

    public String getCurrentUrl() {
        return this.browser.interaction().url();
    }
}
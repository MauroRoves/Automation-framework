package com.tatf.adminces.modules.popUp.pom;

import com.tatf.core.browser.IBrowser;

public class PopUPPO {
    private final IBrowser browser;

    private final String confirmButton = "button.swal2-confirm";
    private final String message = "swal2-html-container";

    public PopUPPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getMensaje() {
        return this.browser.find().id(message).getText();
    }

    public void confirmar() {
        this.browser.find().css(confirmButton).click();
    }
}
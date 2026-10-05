package com.tatf.adminces.modules.reiniciarPass.pom;

import com.tatf.core.browser.IBrowser;

public class ReiniciarPassPO {
    private final IBrowser browser;

    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String repeatPasswordInput = "inputRepeatPassword";
    private final String resetPasswordButton = "btnReset";

    public ReiniciarPassPO(IBrowser browser) {
        this.browser = browser;
    }

    public void enterEmail(String email) {
        this.browser.find().name(emailInput).write(email);
    }

    public void enterPassword(String password) {
        this.browser.find().name(passwordInput).write(password);
    }

    public void enterRepeatPassword(String password) {
        this.browser.find().name(repeatPasswordInput).write(password);
    }

    public void clickReset() {
        this.browser.find().id(resetPasswordButton).click();
    }


}

package com.tatf.adminces.modules.reiniciarPass.pom;

import com.tatf.core.browser.IBrowser;

public class ReiniciarPassPO {
    private final IBrowser browser;

    private final String emailInput = "//input[@name='inputEmail']";
    private final String passwordInput = "//input[@name='inputPassword']";
    private final String repeatPasswordInput = "//input[@name='inputRepeatPassword']";
    private final String resetPasswordButton = "btnReset";
    private final String okButton = "button.swal2-confirm.swal2-styled.swal2-default-outline";

    public ReiniciarPassPO(IBrowser browser) {
        this.browser = browser;
    }

    public void enterEmail(String email) {
        this.browser.find().xpath(emailInput).write(email);
    }

    public void enterPassword(String password) {
        this.browser.find().xpath(passwordInput).write(password);
    }

    public void enterRepeatPassword(String password) {
        this.browser.find().xpath(repeatPasswordInput).write(password);
    }

    public void clickRegister() {
        this.browser.find().id(resetPasswordButton).click();
    }

    public void confirmarAlerta() {
        this.browser.find().css(okButton).click();
    }


}

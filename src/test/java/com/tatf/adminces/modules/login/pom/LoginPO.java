package com.tatf.adminces.modules.login.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {
    private final IBrowser browser;

    private final String iniciarSesionLink = "INICIAR SESIÓN";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String loginButton = "button.btn-orange-ces";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickIniciarSesion() {
        this.browser.find().link(iniciarSesionLink).click();
    }

    public void enterEmail(String email) {
        this.browser.find().name(emailInput).write(email);
    }

    public void clearEmail() {
        this.browser.find().name(emailInput).clear();
    }

    public void enterPassword(String password) {
        this.browser.find().name(passwordInput).write(password);
    }

    public void clearPassword() {
        this.browser.find().name(passwordInput).clear();
    }

    public void clickLogin() {
        this.browser.find().css(loginButton).click();
    }
}
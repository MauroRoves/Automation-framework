package com.tatf.adminces.modules.login.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {
    private final IBrowser browser;

    private final String iniciarSesionLink = "INICIAR SESIÓN";
    private final String emailInput = "//input[@name='inputEmail']";
    private final String passwordInput = "//input[@name='inputPassword']";
    private final String loginButton = "button.btn-orange-ces";
    private final String confirmButton = "button.swal2-confirm";
    private final String mensajeAlerta = "swal2-html-container";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickIniciarSesion() {
        this.browser.find().link(iniciarSesionLink).click();
    }

    public void enterEmail(String email) {
        this.browser.find().xpath(emailInput).write(email);
    }

    public void clearEmail() {
        this.browser.find().xpath(emailInput).clear();
    }

    public void enterPassword(String password) {
        this.browser.find().xpath(passwordInput).write(password);
    }

    public void clearPassword() {
        this.browser.find().xpath(passwordInput).clear();
    }

    public void clickLogin() {
        this.browser.find().css(loginButton).click();
    }

    public String getMensajeAlerta() {
        return this.browser.find().id(mensajeAlerta).getText();
    }

    public void confirmarAlerta() {
        this.browser.find().css(confirmButton).click();
    }


}
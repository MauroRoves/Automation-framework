package com.tatf.adminces.modules.registroAdmin.pom;

import com.tatf.core.browser.IBrowser;

public class RegistroPO {
    private final IBrowser browser;

    private final String title = "h5.mb-4.text-center.title";
    private final String usernameInput = "//input[@name='inputFirstName']";
    private final String lastnameInput = "//input[@name='inputLastName']";
    private final String emailInput = "//input[@name='inputEmail']";
    private final String passwordInput = "//input[@name='inputPassword']";
    private final String repeatPasswordInput = "//input[@name='inputRepeatPassword']";
    private final String paisInput = "//input[@name='inputCountry']";
    private final String loginButton = "btnRegister";
    private final String okButton = "button.swal2-confirm.swal2-styled.swal2-default-outline";

    public RegistroPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle() {
        return this.browser.find().className(title).getText();
    }

    public void enterUsername(String username) {
        this.browser.find().xpath(usernameInput).write(username);
    }

    public void enterLastname(String lastname) {
        this.browser.find().xpath(lastnameInput).write(lastname);
    }

    public void enterEmail(String email) {
        this.browser.find().xpath(emailInput).write(email);
    }

    public void enterPassword(String password) {
        this.browser.find().xpath(passwordInput).write(password);
    }

    public void enterRepeatPassword(String repeatPassword) {
        this.browser.find().xpath(repeatPasswordInput).write(repeatPassword);
    }

    public void enterPais(String pais) {
        this.browser.find().xpath(paisInput).write(pais);
    }

    public void clickRegister() {
        this.browser.find().id(loginButton).click();
    }

    public void confirmarAlerta() {
        this.browser.find().css(okButton).click();
    }


}

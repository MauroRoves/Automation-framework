package com.tatf.adminces.modules.registroAdmin.pom;

import com.tatf.core.browser.IBrowser;

public class RegistroPO {
    private final IBrowser browser;

    private final String title = "h5.mb-4.text-center.title";
    private final String firstNameInput = "inputFirstName";
    private final String lastNameInput = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String passwordInput = "inputPassword";
    private final String repeatPasswordInput = "inputRepeatPassword";
    private final String countryInput = "inputCountry";
    private final String registerButton = "btnRegister";

    public RegistroPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle() {
        return this.browser.find().css(title).getText();
    }

    public void enterFirstName(String nombre) {
        this.browser.find().name(firstNameInput).write(nombre);
    }

    public void enterLastName(String apellido) {
        this.browser.find().name(lastNameInput).write(apellido);
    }

    public void enterEmail(String email) {
        this.browser.find().name(emailInput).write(email);
    }

    public void enterPassword(String password) {
        this.browser.find().name(passwordInput).write(password);
    }

    public void enterRepeatPassword(String repeatPassword) {
        this.browser.find().name(repeatPasswordInput).write(repeatPassword);
    }

    public void enterCountry(String pais) {
        this.browser.find().name(countryInput).write(pais);
    }

    public void clickRegister() {
        this.browser.find().id(registerButton).click();
    }


}

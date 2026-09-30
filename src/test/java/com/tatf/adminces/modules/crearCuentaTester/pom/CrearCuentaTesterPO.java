package com.tatf.adminces.modules.crearCuentaTester.pom;

import com.tatf.core.browser.IBrowser;

public class CrearCuentaTesterPO {
    private final IBrowser browser;

    private final String firstNameInput = "//input[@name='inputFirstName']";
    private final String lastNameInput = "//input[@name='inputLastName']";
    private final String emailInput = "//input[@name='inputEmail']";
    private final String countrySelect = "//select[@name='inputCountry']";
    private final String passwordInput = "//input[@name='inputPassword']";
    private final String testerJuniorOption = "testerJunior";
    private final String registerButton = "btnRegister";
    private final String confirmButton = "button.swal2-confirm";

    public CrearCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void enterFirstName(String nombre) {
        this.browser.find().xpath(firstNameInput).write(nombre);
    }

    public void enterLastName(String apellido) {
        this.browser.find().xpath(lastNameInput).write(apellido);
    }

    public void enterEmail(String email) {
        this.browser.find().xpath(emailInput).write(email);
    }

    public void selectCountry(String pais) {
        this.browser.find().xpath(countrySelect).selectValue(pais);
    }

    public void enterPassword(String password) {
        this.browser.find().xpath(passwordInput).write(password);
    }

    public void selectTesterJunior() {
        this.browser.find().id(testerJuniorOption).click();
    }

    public void clickRegister() {
        this.browser.find().id(registerButton).click();
    }

    public void confirmarAlerta() {
        this.browser.find().css(confirmButton).click();
    }
}

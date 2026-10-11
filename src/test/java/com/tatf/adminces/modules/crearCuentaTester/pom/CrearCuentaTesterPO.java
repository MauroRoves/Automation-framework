package com.tatf.adminces.modules.crearCuentaTester.pom;

import com.tatf.core.browser.IBrowser;

public class CrearCuentaTesterPO {
    private final IBrowser browser;

    private final String firstNameInput = "inputFirstName";
    private final String lastNameInput = "inputLastName";
    private final String emailInput = "inputEmail";
    private final String countrySelect = "inputCountry";
    private final String passwordInput = "inputPassword";
    private final String testerJuniorOption = "testerJunior";
    private final String testerSeniorOption = "testerSenior";
    private final String testerLiderOption = "testerLead";
    private final String registerButton = "btnRegister";

    public CrearCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
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

    public void selectCountry(String pais) {
        this.browser.find().name(countrySelect).selectValue(pais);
    }

    public void enterPassword(String password) {
        this.browser.find().name(passwordInput).write(password);
    }

    /*
    public void selectTesterJunior() {
        this.browser.find().id(testerJuniorOption).click();
    }
    */

    public void selectPerfil(String perfil) {
        switch (perfil) {
            case "Tester Junior":
                this.browser.find().id(testerJuniorOption).click();
                break;
            case "Tester Senior":
                this.browser.find().id(testerSeniorOption).click();
                break;
            case "Tester Líder":
            this.browser.find().id(testerLiderOption).click();
            break;
            default:
                throw new IllegalArgumentException("El pefil no coincide: " + perfil);
        }
    }

    public void clickRegister() {
        this.browser.find().id(registerButton).click();
    }
}

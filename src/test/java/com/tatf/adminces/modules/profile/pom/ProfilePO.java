package com.tatf.adminces.modules.profile.pom;

import com.tatf.core.browser.IBrowser;

public class ProfilePO {
    private final IBrowser browser;

    public ProfilePO(IBrowser browser) {
        this.browser = browser;
    }

    public String getNombre() {
        return this.browser.find().name("inputFirstName").getAttribute("value");
    }

    public String getApellido() {
        return this.browser.find().name("inputLastName").getAttribute("value");
    }

    public String getEmail() {
        return this.browser.find().name("inputEmail").getAttribute("value");
    }

    public String getPais() {
        return this.browser.find().name("inputCountry").getAttribute("value");
    }

    public String getPerfil() {
        return this.browser.find().css("input[value='Administrador']").getAttribute("value");
    }


}

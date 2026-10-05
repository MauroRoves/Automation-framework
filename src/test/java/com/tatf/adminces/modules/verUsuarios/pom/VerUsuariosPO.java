package com.tatf.adminces.modules.verUsuarios.pom;

import com.tatf.core.browser.IBrowser;

public class VerUsuariosPO {

    private final IBrowser browser;

    private final String nombrePorEmailTemplate = "//td[text()=\"%s\"]/preceding-sibling::td[2]";
    private final String apellidoPorEmailTemplate = "//td[text()=\"%s\"]/preceding-sibling::td[1]";
    private final String emailEnTablaTemplate = "//td[text()=\"%s\"]";
    private final String paisPorEmailTemplate = "//td[text()='%s']/following-sibling::td[1]";
    private final String perfilPorEmailTemplate = "//td[text()='%s']/following-sibling::td[2]";

    public VerUsuariosPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getNombrePorEmail(String email) {
        String selector = String.format(nombrePorEmailTemplate, email);
        return this.browser.find().xpath(selector).getText();
    }

    public String getApellidoPorEmail(String email) {
        String selector = String.format(apellidoPorEmailTemplate, email);
        return this.browser.find().xpath(selector).getText();
    }

    public String getEmailEnTabla(String email) {
        String selector = String.format(emailEnTablaTemplate, email);
        return this.browser.find().xpath(selector).getText();
    }

    public String getPaisPorEmail(String email) {
        String selector = String.format(paisPorEmailTemplate, email);
        return this.browser.find().xpath(selector).getText();
    }

    public String getPerfilPorEmail(String email) {
        String selector = String.format(perfilPorEmailTemplate, email);
        return this.browser.find().xpath(selector).getText();
    }

    public void clickEliminar(String email) {
        this.browser.find().id(email).click();
    }

    public boolean existeUsuario(String email) {
        String selector = String.format(emailEnTablaTemplate, email);
        try {
            this.browser.find().xpath(selector).getText();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

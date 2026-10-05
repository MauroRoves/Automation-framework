package com.tatf.adminces.modules.acceso.pom;

import com.tatf.core.browser.IBrowser;

public class AccesoPO {
    private final IBrowser browser;

    public AccesoPO(IBrowser browser) {
        this.browser = browser;
    }

    private final String crearUsuarioAdminButton = "REGISTRARSE";
    private final String reiniciarPasswordButton = "REINICIAR CONTRASEÑA";
    private final String iniciarSesionButton = "INICIAR SESIÓN";
    private final String crearUsuarioTester = "CREAR USUARIO";
    private final String verUsuariosButton = "//a[@data-bs-toggle='dropdown']";
    private final String verPerfilButton = "//a[@href='/adminces/profile']";
    private final String verListaUsuariosButton = "VER USUARIOS";


    public String getButtonCrearUsuarioAdmin() {
        return this.browser.find().link(crearUsuarioAdminButton).getText();
    }

    public String getButtonReiniciarPassword() {
        return this.browser.find().link(reiniciarPasswordButton).getText();
    }

    public String getButtonIniciarSesion() {
        return this.browser.find().link(iniciarSesionButton).getText();
    }

    public String getButtonCrearUsuarioTester() {
        return this.browser.find().link(crearUsuarioTester).getText();
    }

    public void apretarCrearUsuarioAdmin() {
        this.browser.find().link(crearUsuarioAdminButton).click();
    }

    public void apretarReiniciarPassword() {
        this.browser.find().link(reiniciarPasswordButton).click();
    }

    public void apretarCrearUsuarioTester() {
        this.browser.find().link(crearUsuarioTester).click();
    }


    /*
    public void apretarIniciarSesion() {
        this.browser.find().link(iniciarSesionButton).click();
    }
    */

    //ver posible selector css
    public void abrirMenuUsuario() {
        this.browser.find().xpath(verUsuariosButton).click();
    }

    //ver posible selector css
    public void irAPerfil() {
        this.browser.find().xpath(verPerfilButton).click();
    }

    public void irAVerUsuarios() {
        this.browser.find().link(verListaUsuariosButton).click();
    }

    public String getCurrentUrl() {
        return this.browser.interaction().url();
    }

}
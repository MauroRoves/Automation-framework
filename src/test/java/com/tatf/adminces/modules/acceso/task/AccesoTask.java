package com.tatf.adminces.modules.acceso.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.adminces.modules.acceso.pom.AccesoPO;
import com.tatf.core.verification.IVerify;

public class AccesoTask {
    private final AccesoPO acceso;

    public AccesoTask(IBrowser browser) {
        this.acceso = new AccesoPO(browser);
    }


    public void verifyButtonCrearCuentaAdmin(String button) {
        IVerify.create().verify(button, this.acceso.getButtonCrearUsuarioAdmin(), "No se encuentra el boton.");
    }

    public void verifyButtonReiniciarPassword(String button) {
        IVerify.create().verify(button, this.acceso.getButtonReiniciarPassword(), "No se encuentra el boton.");
    }

    public void verifyButtonIniciarSesion(String button) {
        IVerify.create().verify(button, this.acceso.getButtonIniciarSesion(), "No se encuentra el boton.");
    }

    public void verifyButtonCrearCuentaTester(String button) {
        IVerify.create().verify(button, this.acceso.getButtonCrearUsuarioTester(), "No se encuentra el boton.");
    }



    public void irCrearCuentaAdmin() {
        this.acceso.apretarCrearUsuarioAdmin();
    }


    public void verifyUrl(String url) {
        IVerify.create().verify(url, this.acceso.getCurrentUrl(), "No se encuentra en la página esperada.");
    }


    public void irAPerfil() {
        this.acceso.abrirMenuUsuario();
        this.acceso.irAPerfil();
    }

    public void irReiniciarPassword() {
        this.acceso.apretarReiniciarPassword();
    }


    public void irAVerUsuarios() {
        this.acceso.irAVerUsuarios();
    }


    public void irCrearCuentaTester() {
        this.acceso.apretarCrearUsuarioTester();
    }


}
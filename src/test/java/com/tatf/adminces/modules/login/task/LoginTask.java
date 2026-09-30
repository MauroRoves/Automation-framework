package com.tatf.adminces.modules.login.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.adminces.modules.login.pom.LoginPO;

public class LoginTask {
    private final LoginPO login;

    public LoginTask(IBrowser browser) {
        this.login = new LoginPO(browser);
    }

    public void iniciarSesion(String email, String password) {
        this.login.clickIniciarSesion();
        this.login.enterEmail(email);
        this.login.enterPassword(password);
        this.login.clickLogin();
        this.login.getMensajeAlerta();
        this.login.confirmarAlerta();
    }

    public void reintentarLogin(String email, String password) {
        this.login.clearEmail();
        this.login.enterEmail(email);
        this.login.clearPassword();
        this.login.enterPassword(password);
        this.login.clickLogin();
        this.login.getMensajeAlerta();
        this.login.confirmarAlerta();
    }


    public void confirmarAlerta() {
        this.login.confirmarAlerta();
    }


    public void verifyMensaje(String mensajeEsperado) {
        IVerify.create().verify(mensajeEsperado, this.login.getMensajeAlerta(), "El mensaje no coincide.");
    }
}
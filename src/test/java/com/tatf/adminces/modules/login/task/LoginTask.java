package com.tatf.adminces.modules.login.task;

import com.tatf.adminces.modules.popUp.pom.PopUPPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.adminces.modules.login.pom.LoginPO;

public class LoginTask {
    private final LoginPO login;
    private final PopUPPO popUp;

    public LoginTask(IBrowser browser) {
        this.login = new LoginPO(browser);
        this.popUp = new PopUPPO(browser);
    }

    public void iniciarSesion(String email, String password) {
        this.login.clickIniciarSesion();
        this.login.enterEmail(email);
        this.login.enterPassword(password);
        this.login.clickLogin();
        this.popUp.confirmar();
    }

    public void reintentarLogin(String email, String password) {
        this.login.clearEmail();
        this.login.enterEmail(email);
        this.login.clearPassword();
        this.login.enterPassword(password);
        this.login.clickLogin();
        this.popUp.confirmar();
    }


    public void verifyMensaje(String mensajeEsperado) {
        IVerify.create().verify(mensajeEsperado, this.popUp.getMensaje(), "El mensaje no coincide.");
    }
}
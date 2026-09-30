package com.tatf.adminces.modules.registroAdmin.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.adminces.modules.registroAdmin.pom.RegistroPO;

public class RegistroTask {
    private final IBrowser browser;
    private final RegistroPO registro;

    public RegistroTask(IBrowser browser) {
        this.browser = browser;
        this.registro = new RegistroPO(this.browser);
    }

    /*public void verifyTitle(String title) {
        IVerify.create().verify(RegistroData.TITLE, this.registro.getTitle(), "El título no es el esperado.");
    }*/


    public void registerAdminAndVerify(String username, String lastname,String email, String password, String repeatPassword, String pais) {
        this.registro.enterUsername(username);
        this.registro.enterLastname(lastname);
        this.registro.enterEmail(email);
        this.registro.enterPassword(password);
        this.registro.enterRepeatPassword(repeatPassword);
        this.registro.enterPais(pais);
        this.registro.clickRegister();
        this.registro.confirmarAlerta();
    }
}

package com.tatf.adminces.modules.registroAdmin.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.adminces.modules.registroAdmin.pom.RegistroPO;
import com.tatf.adminces.modules.popUp.pom.PopUPPO;

public class RegistroTask {
    private final IBrowser browser;
    private final RegistroPO registro;
    private final PopUPPO popUP;

    public RegistroTask(IBrowser browser) {
        this.browser = browser;
        this.registro = new RegistroPO(this.browser);
        this.popUP = new PopUPPO(this.browser);
    }


    public void registrarAdmin(String nombre, String apellido, String email, String password, String repeatPassword, String pais) {
        this.registro.enterFirstName(nombre);
        this.registro.enterLastName(apellido);
        this.registro.enterEmail(email);
        this.registro.enterPassword(password);
        this.registro.enterRepeatPassword(repeatPassword);
        this.registro.enterCountry(pais);
        this.registro.clickRegister();
        this.popUP.confirmar();
    }
}

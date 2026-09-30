package com.tatf.adminces.modules.crearCuentaTester.task;

import com.tatf.adminces.modules.crearCuentaTester.pom.CrearCuentaTesterPO;
import com.tatf.core.browser.IBrowser;


public class CrearCuentaTesterTask {
    private final CrearCuentaTesterPO crearcuentaTesterPO;

    public CrearCuentaTesterTask(IBrowser browser) {
        this.crearcuentaTesterPO = new CrearCuentaTesterPO(browser);
    }

    public void crearUsuarioTester(String nombre, String apellido, String email, String pais, String password) {
        this.crearcuentaTesterPO.enterFirstName(nombre);
        this.crearcuentaTesterPO.enterLastName(apellido);
        this.crearcuentaTesterPO.enterEmail(email);
        this.crearcuentaTesterPO.selectCountry(pais);
        this.crearcuentaTesterPO.enterPassword(password);
        this.crearcuentaTesterPO.selectTesterJunior();
        this.crearcuentaTesterPO.clickRegister();
        this.crearcuentaTesterPO.confirmarAlerta();
    }
}

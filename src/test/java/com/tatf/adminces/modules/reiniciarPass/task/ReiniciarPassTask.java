package com.tatf.adminces.modules.reiniciarPass.task;

import com.tatf.adminces.modules.reiniciarPass.pom.ReiniciarPassPO;
import com.tatf.core.browser.IBrowser;

public class ReiniciarPassTask {
    private final IBrowser browser;
    private final ReiniciarPassPO reiniciarPass;

    public ReiniciarPassTask(IBrowser browser) {
        this.browser = browser;
        this.reiniciarPass = new ReiniciarPassPO(this.browser);
    }

    public void reiniciarPassword(String email, String password, String repeatPassword) {
        this.reiniciarPass.enterEmail(email);
        this.reiniciarPass.enterPassword(password);
        this.reiniciarPass.enterRepeatPassword(repeatPassword);
        this.reiniciarPass.clickRegister();
        this.reiniciarPass.confirmarAlerta();
    }
}

package com.tatf.adminces.modules.reiniciarPass.task;

import com.tatf.adminces.modules.reiniciarPass.pom.ReiniciarPassPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.adminces.modules.popUp.pom.PopUPPO;

public class ReiniciarPassTask {
    private final ReiniciarPassPO reiniciarPass;
    private final PopUPPO popup;

    public ReiniciarPassTask(IBrowser browser) {
        this.reiniciarPass = new ReiniciarPassPO(browser);
        this.popup = new PopUPPO(browser);
    }

    public void reiniciarPassword(String email, String password, String repeatPassword) {
        this.reiniciarPass.enterEmail(email);
        this.reiniciarPass.enterPassword(password);
        this.reiniciarPass.enterRepeatPassword(repeatPassword);
        this.reiniciarPass.clickReset();
        this.popup.confirmar();
    }
}

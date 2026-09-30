package com.tatf.adminces.modules.ingreso.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.adminces.modules.ingreso.pom.IngresoPO;

public class IngresoTask {
    private final IngresoPO ingreso;

    public IngresoTask(IBrowser browser) {
        this.ingreso = new IngresoPO(browser);
    }

    public void ingresarAPaginaAdminCES(String url, String hash) {
        this.ingreso.navigateTo(url);
        this.ingreso.enterHash(hash);
        this.ingreso.submit();
    }

    public void verifyUrl(String urlEsperada) {
        IVerify.create().verify(urlEsperada, this.ingreso.getCurrentUrl(), "No se encuentra en la página esperada.");
    }
}
package com.tatf.adminces.modules.ingreso.test;

import com.tatf.adminces.modules.ingreso.data.IngresoData;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IngresoTest extends BaseTest {

    private IngresoTask ingresoTask;

    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
    }

    @Disabled
    @Test
    @DisplayName("Acceso al sitio AdminCES")
    public void accesoAdminCES() {
        this.ingresoTask.ingresarAPaginaAdminCES(IngresoData.URL_ESPERADA, IngresoData.HASH);
        this.ingresoTask.verifyUrl(IngresoData.URL_ESPERADA);
    }
}

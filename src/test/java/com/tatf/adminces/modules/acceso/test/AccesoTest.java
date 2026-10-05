package com.tatf.adminces.modules.acceso.test;

import com.tatf.adminces.modules.acceso.data.AccesoData;
import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.ingreso.data.IngresoData;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.registroAdmin.data.RegistroData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccesoTest extends BaseTest {
    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;

    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.accesoTask = new AccesoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(IngresoData.URL_ESPERADA, IngresoData.HASH);
        this.ingresoTask.verifyUrl(IngresoData.URL_ESPERADA);
    }

    @Disabled
    @Test
    @DisplayName("Acceder a registrar usuario Admin")
    public void irRegistrarUsuarioAdmin() {
        this.accesoTask.verifyButtonCrearCuentaAdmin(AccesoData.BOTON_REGISTRARSE);
        this.accesoTask.irCrearCuentaAdmin();
        this.accesoTask.verifyUrl(RegistroData.URL_REGISTRAR_ADMIN_ESPERADA);
    }

}

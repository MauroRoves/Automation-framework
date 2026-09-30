package com.tatf.adminces.modules.reiniciarPass.test;

import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.reiniciarPass.data.ReiniciarPassData;
import com.tatf.adminces.modules.reiniciarPass.task.ReiniciarPassTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReiniciarPassTest extends BaseTest {

    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;
    private ReiniciarPassTask reiniciarPassTask;
    private LoginTask ingresoPredeterminadaTask;

    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(URL_ESPERADA, HASH);
        this.ingresoTask.verifyUrl(URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.reiniciarPassTask = new ReiniciarPassTask(browser);
        this.ingresoPredeterminadaTask = new LoginTask(browser);

    }

    @Test
    @DisplayName("Reiniciar password de cuenta Predeterminada y verificar")
    public void registrarAdminTest() {
        this.accesoTask.verifyButtonReiniciarPassword(BOTON_REINICIAR_CONTRASENA);
        this.accesoTask.irReiniciarPassword();
        this.accesoTask.verifyUrl(ReiniciarPassData.URL_REINICIAR_PASSWORD_ESPERADA);
        this.reiniciarPassTask.reiniciarPassword(PREDETERMINADA_EMAIL, PREDETERMINADA_NUEVA_PASSWORD, PREDETERMINADA_REPETIR_NUEVA_PASSWORD);
        this.ingresoPredeterminadaTask.iniciarSesion(PREDETERMINADA_EMAIL, PREDETERMINADA_PASSWORD);
        this.ingresoPredeterminadaTask.reintentarLogin(PREDETERMINADA_EMAIL, PREDETERMINADA_NUEVA_PASSWORD);
    }
}

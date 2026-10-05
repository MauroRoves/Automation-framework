package com.tatf.adminces.modules.reiniciarPass.test;

import com.tatf.adminces.modules.acceso.data.AccesoData;
import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.ingreso.data.IngresoData;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.reiniciarPass.data.ReiniciarPassData;
import com.tatf.adminces.modules.reiniciarPass.task.ReiniciarPassTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ReiniciarPassTest extends BaseTest {

    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;
    private ReiniciarPassTask reiniciarPassTask;
    private LoginTask ingresoPredeterminadaTask;

    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(IngresoData.URL_ESPERADA, IngresoData.HASH);
        this.ingresoTask.verifyUrl(IngresoData.URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.reiniciarPassTask = new ReiniciarPassTask(browser);
        this.ingresoPredeterminadaTask = new LoginTask(browser);

    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/reiniciarPass.csv",
            useHeadersInDisplayName = true
    )
    @DisplayName("Reiniciar password de cuenta Predeterminada y verificar")
    public void registrarAdminTest(String nuevaPassword, String repetirNuevaPassword) {
        this.accesoTask.verifyButtonReiniciarPassword(AccesoData.BOTON_REINICIAR_CONTRASENA);
        this.accesoTask.irReiniciarPassword();
        this.accesoTask.verifyUrl(ReiniciarPassData.URL_REINICIAR_PASSWORD_ESPERADA);
        this.reiniciarPassTask.reiniciarPassword(LoginData.PREDETERMINADA_EMAIL,
                nuevaPassword, repetirNuevaPassword);
        this.ingresoPredeterminadaTask.iniciarSesion(LoginData.PREDETERMINADA_EMAIL, LoginData.PREDETERMINADA_PASSWORD);
        this.ingresoPredeterminadaTask.reintentarLogin(LoginData.PREDETERMINADA_EMAIL, nuevaPassword);
    }
}

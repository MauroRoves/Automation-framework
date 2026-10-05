package com.tatf.adminces.modules.verUsuarios.test;

import com.tatf.adminces.modules.acceso.data.AccesoData;
import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.ingreso.data.IngresoData;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.verUsuarios.data.VerUsuariosData;
import com.tatf.adminces.modules.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class VerUsuariosTest extends BaseTest {
    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;
    private LoginTask ingresoPredeterminadaTask;
    private VerUsuariosTask verUsuariosTask;


    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(IngresoData.URL_ESPERADA, IngresoData.HASH);
        this.ingresoTask.verifyUrl(IngresoData.URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.ingresoPredeterminadaTask = new LoginTask(browser);
        this.verUsuariosTask = new VerUsuariosTask(browser);


    }


    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/eliminarTester.csv",
            useHeadersInDisplayName = true
    )
    @DisplayName("Elimina una cuenta de usuario Tester")
    public void eliminarCuentaTester(String emailTester) {
        this.accesoTask.verifyButtonIniciarSesion(AccesoData.BOTON_INICIAR_SESION);
        this.ingresoPredeterminadaTask.iniciarSesion(LoginData.PREDETERMINADA_EMAIL, LoginData.PREDETERMINADA_PASSWORD);
        this.accesoTask.irAVerUsuarios();
        this.accesoTask.verifyUrl(VerUsuariosData.URL_VER_USUARIOS_ESPERADA);
        this.verUsuariosTask.eliminarUsuarioTester(emailTester);
        this.verUsuariosTask.verificarUsuarioEliminado(emailTester);

    }
}


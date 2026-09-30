package com.tatf.adminces.modules.verUsuarios.test;

import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.profile.task.ProfileTask;
import com.tatf.adminces.modules.verUsuarios.data.VerUsuariosData;
import com.tatf.adminces.modules.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VerUsuariosTest extends BaseTest {
    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;
    private LoginTask ingresoPredeterminadaTask;
    private ProfileTask profileTask;
    private CrearCuentaTesterTask crearCuentaTesterTask;
    private VerUsuariosTask verUsuariosTask;


    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(URL_ESPERADA, HASH);
        this.ingresoTask.verifyUrl(URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.ingresoPredeterminadaTask = new LoginTask(browser);
        this.verUsuariosTask = new VerUsuariosTask(browser);


    }


    @Test
    @DisplayName("Elimina una cuenta de usuario Tester")
    public void eliminarCuentaTester() {
        this.accesoTask.verifyButtonIniciarSesion(BOTON_INICIAR_SESION);
        this.ingresoPredeterminadaTask.iniciarSesion(PREDETERMINADA_EMAIL, PREDETERMINADA_PASSWORD);
        this.accesoTask.irAVerUsuarios();
        this.accesoTask.verifyUrl(VerUsuariosData.URL_VER_USUARIOS_ESPERADA);
        this.verUsuariosTask.eliminarUsuarioTester(EMAIL_TESTER_A_BORRAR);
        this.verUsuariosTask.verificarUsuarioEliminado(EMAIL_TESTER_A_BORRAR);

    }
}


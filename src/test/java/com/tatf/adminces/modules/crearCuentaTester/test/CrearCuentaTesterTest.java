package com.tatf.adminces.modules.crearCuentaTester.test;

import com.tatf.adminces.modules.acceso.data.AccesoData;
import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.profile.task.ProfileTask;
import com.tatf.adminces.modules.reiniciarPass.data.ReiniciarPassData;
import com.tatf.adminces.modules.verUsuarios.data.VerUsuariosData;
import com.tatf.adminces.modules.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearCuentaTesterTest extends BaseTest {

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
        this.profileTask = new ProfileTask(browser);
        this.crearCuentaTesterTask = new CrearCuentaTesterTask(browser);
        this.verUsuariosTask = new VerUsuariosTask(browser);


    }

    @Test
    @DisplayName("Crear cuenta Tester Junior y verificar")
    public void crearCuentaTester() {
        this.accesoTask.verifyButtonIniciarSesion(BOTON_INICIAR_SESION);
        this.ingresoPredeterminadaTask.iniciarSesion(PREDETERMINADA_EMAIL, PREDETERMINADA_PASSWORD);
        this.accesoTask.verifyButtonCrearCuentaTester(BOTON_CREAR_USUARIO);
        this.accesoTask.irCrearCuentaTester();
        this.crearCuentaTesterTask.crearUsuarioTester(NOMBRE_TESTER, APELLIDO_TESTER, EMAIL_TESTER, PAIS_TESTER, PASSWORD_TESTER);
        this.accesoTask.irAVerUsuarios();
        this.accesoTask.verifyUrl(VerUsuariosData.URL_VER_USUARIOS_ESPERADA);
        this.verUsuariosTask.verificarUsuarioEnLista(EMAIL_TESTER, NOMBRE_TESTER, APELLIDO_TESTER, PAIS_TESTER, PERFIL_TESTER);


    }


}

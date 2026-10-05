package com.tatf.adminces.modules.crearCuentaTester.test;

import com.tatf.adminces.modules.acceso.data.AccesoData;
import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.data.CrearCuentaTesterData;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.profile.task.ProfileTask;
import com.tatf.adminces.modules.reiniciarPass.data.ReiniciarPassData;
import com.tatf.adminces.modules.verUsuarios.data.VerUsuariosData;
import com.tatf.adminces.modules.verUsuarios.task.VerUsuariosTask;
import com.tatf.adminces.modules.ingreso.data.IngresoData;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
        this.ingresoTask.ingresarAPaginaAdminCES(IngresoData.URL_ESPERADA, IngresoData.HASH);
        this.ingresoTask.verifyUrl(IngresoData.URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.ingresoPredeterminadaTask = new LoginTask(browser);
        this.profileTask = new ProfileTask(browser);
        this.crearCuentaTesterTask = new CrearCuentaTesterTask(browser);
        this.verUsuariosTask = new VerUsuariosTask(browser);


    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/crearCuentaTester.csv",
            useHeadersInDisplayName = true
    )
    @DisplayName("Crear cuenta Tester Junior y verificar")
    public void crearCuentaTester(String nombre, String apellido, String email, String pais,
                                  String password, String perfil) {
        this.accesoTask.verifyButtonIniciarSesion(AccesoData.BOTON_INICIAR_SESION);
        this.ingresoPredeterminadaTask.iniciarSesion(LoginData.PREDETERMINADA_EMAIL, LoginData.PREDETERMINADA_PASSWORD);
        this.accesoTask.verifyButtonCrearCuentaTester(AccesoData.BOTON_CREAR_USUARIO);
        this.accesoTask.irCrearCuentaTester();
        this.crearCuentaTesterTask.crearUsuarioTester(nombre ,apellido ,email ,pais ,password);
        this.accesoTask.irAVerUsuarios();
        this.accesoTask.verifyUrl(VerUsuariosData.URL_VER_USUARIOS_ESPERADA);
        this.verUsuariosTask.verificarUsuarioEnLista(email, nombre, apellido, pais, perfil);
    }


}

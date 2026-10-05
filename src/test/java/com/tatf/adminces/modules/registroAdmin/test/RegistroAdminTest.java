package com.tatf.adminces.modules.registroAdmin.test;

import com.tatf.adminces.modules.acceso.data.AccesoData;
import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.ingreso.data.IngresoData;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.registroAdmin.data.RegistroData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.tatf.adminces.modules.profile.task.ProfileTask;
import com.tatf.adminces.modules.registroAdmin.task.RegistroTask;
import com.tatf.adminces.modules.base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RegistroAdminTest extends BaseTest {

    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;
    private RegistroTask registrarAdminTask;
    private LoginTask ingresoAdminTask;
    private ProfileTask profileTask;


    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(IngresoData.URL_ESPERADA, IngresoData.HASH);
        this.ingresoTask.verifyUrl(IngresoData.URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.registrarAdminTask = new RegistroTask(browser);
        this.ingresoAdminTask = new LoginTask(browser);
        this.profileTask = new ProfileTask(browser);


    }


    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/registroAdmin.csv",
            useHeadersInDisplayName = true
    )
    @DisplayName("Registrar admin con usuario y contraseña correctos")
    public void registrarAdminTest(String nombre, String apellido, String email, String password,
                                   String repetirPassword, String pais, String perfil) {
        this.accesoTask.verifyButtonCrearCuentaAdmin(AccesoData.BOTON_REGISTRARSE);
        this.accesoTask.irCrearCuentaAdmin();
        this.accesoTask.verifyUrl(RegistroData.URL_REGISTRAR_ADMIN_ESPERADA);
        this.registrarAdminTask.registrarAdmin(nombre, apellido, email, password, repetirPassword, pais);
        this.ingresoAdminTask.iniciarSesion(email, password);
        this.accesoTask.irAPerfil();
        this.profileTask.verificarDatosAdmin(nombre, apellido, email, pais, perfil);
    }
}


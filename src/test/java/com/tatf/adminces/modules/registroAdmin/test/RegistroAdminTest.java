package com.tatf.adminces.modules.registroAdmin.test;

import com.tatf.adminces.modules.acceso.task.AccesoTask;
import com.tatf.adminces.modules.ingreso.task.IngresoTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.registroAdmin.data.RegistroData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.tatf.adminces.modules.profile.task.ProfileTask;
import com.tatf.adminces.modules.registroAdmin.task.RegistroTask;
import com.tatf.adminces.modules.base.BaseTest;

public class RegistroAdminTest extends BaseTest {

    private IngresoTask ingresoTask;
    private AccesoTask accesoTask;
    private RegistroTask registrarAdminTask;
    private LoginTask ingresoAdminTask;
    private ProfileTask profileTask;


    @BeforeEach
    public void configurar() {
        this.ingresoTask = new IngresoTask(browser);
        this.ingresoTask.ingresarAPaginaAdminCES(URL_ESPERADA, HASH);
        this.ingresoTask.verifyUrl(URL_ESPERADA);
        this.accesoTask = new AccesoTask(browser);
        this.registrarAdminTask = new RegistroTask(browser);
        this.ingresoAdminTask = new LoginTask(browser);
        this.profileTask = new ProfileTask(browser);


    }


    @Test
    @DisplayName("Registrar admin con usuario y contraseña correctos")
    public void registrarAdminTest() {
        this.accesoTask.verifyButtonCrearCuentaAdmin(BOTON_REGISTRARSE);
        this.accesoTask.irCrearCuentaAdmin();
        this.accesoTask.verifyUrl(RegistroData.URL_REGISTRAR_ADMIN_ESPERADA);
        this.registrarAdminTask.registerAdminAndVerify(ADMIN_NOMBRE, ADMIN_APELLIDO, ADMIN_EMAIL, ADMIN_PASSWORD, ADMIN_REPETIR_PASSWORD, ADMIN_PAIS);
        this.ingresoAdminTask.iniciarSesion(ADMIN_EMAIL, ADMIN_PASSWORD);
        this.accesoTask.irAPerfil();
        this.profileTask.verificarDatosAdmin(ADMIN_NOMBRE, ADMIN_APELLIDO, ADMIN_EMAIL, ADMIN_PAIS, ADMIN_PERFIL);
    }
}


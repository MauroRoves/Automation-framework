package com.tatf.adminces.modules.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static IBrowser browser;
    protected static String url;
    protected static String hash;

    //URL principal
    public static final String URL_ESPERADA = "http://cestore.ces.com.uy/adminces/";
    //HASH
    public static final String HASH = "3)ea60e0be3ba12c6ecd%7297868%5c4";

    //URL de package acceso
    //public static final String URL_REGISTRAR_ADMIN_ESPERADA = "http://cestore.ces.com.uy/adminces/register";
    //public static final String URL_REINICIAR_PASSWORD_ESPERADA = "http://cestore.ces.com.uy/adminces/forgot-password";
    //public static final String URL_INICIAR_SESION_ESPERADA = "http://cestore.ces.com.uy/adminces/login";
    //public static final String URL_VER_USUARIOS_ESPERADA = "http://cestore.ces.com.uy/adminces/view-users";

    //Cuenta usuario Tester a Crear
    protected static final String NOMBRE_TESTER = "Diego";
    protected static final String APELLIDO_TESTER = "Rodriguez";
    protected static final String EMAIL_TESTER = "diego@gmail.com";
    protected static final String PAIS_TESTER = "Uruguay";
    protected static final String PASSWORD_TESTER = "1234567";
    protected static final String PERFIL_TESTER = "Tester Junior";

    //Cuenta usuario Admin a Crear
    public static final String ADMIN_NOMBRE = "Mauro";
    public static final String ADMIN_APELLIDO = "Roves";
    public static final String ADMIN_EMAIL = "mauro@gmail.com";
    public static final String ADMIN_PASSWORD = "54321";
    public static final String ADMIN_REPETIR_PASSWORD = "54321";
    public static final String ADMIN_PAIS = "Uruguay";
    public static final String ADMIN_PERFIL = "Administrador";

    //Credenciales cuenta predeterminada
    public static final String PREDETERMINADA_EMAIL = "yaniscorrea@gmail.com";
    public static final String PREDETERMINADA_PASSWORD = "12345";

    //Nueva contraseña cuenta predeterminada
    public static final String PREDETERMINADA_NUEVA_PASSWORD = "98765";
    public static final String PREDETERMINADA_REPETIR_NUEVA_PASSWORD = "98765";

    //Datos para borrar cuenta tester
    public static final String EMAIL_TESTER_A_BORRAR = "dardo@gmail.com";

    //Selectores de botones
    //Nota: Me confundi a la hora de ubicar los selectores, entiendo que deberian ir en los "PO", porque son selectores de una pagina en particular.
    //
    public static final String BOTON_REGISTRARSE = "REGISTRARSE";
    public static final String BOTON_INICIAR_SESION = "INICIAR SESIÓN";
    public static final String BOTON_REINICIAR_CONTRASENA = "REINICIAR CONTRASEÑA";
    public static final String BOTON_CREAR_USUARIO = "CREAR USUARIO";
    public static final String BOTON_VER_USUARIOS = "VER USUARIOS";
    //public static final String BOTON_DROPDOWN = "//a[@data-bs-toggle='dropdown']";
    //public static final String BOTON_VER_PERFIL = "//a[@href='/adminces/profile']";



    @BeforeAll
    static public void configuration() {
        browser = BrowserFactory.getBrowser(true);
        url = "http://cestore.ces.com.uy/adminces/";
        hash = "3)ea60e0be3ba12c6ecd%7297868%5c4";

    }


    /*@AfterAll
    static public void close() {
        BrowserFactory.quitBrowser();
    }*/
}
package com.tatf.tests;


import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdmCES {

    private static String url = "http://cestore.ces.com.uy/adminces/";
    private static String hash = "3)ea60e0be3ba12c6ecd%7297868%5c4";

    //Credenciales "Administrador"
    private static IBrowser browser;
    private static String nombre = "Mauro";
    private static String apellido = "Roves";
    private static String emailAdmin = "mauro@gmail.com";
    private static String passwordAdmin = "54321";
    private static String repetirPasswordAdmin = "54321";
    private static String pais = "Uruguay";

    //Credenciales de cuenta predeterminada
    private static String emailPredeterminado = "yaniscorrea@gmail.com";
    private static String passwordPredeterminada = "12345";

    //Variables para Reiniciar contraseña
    private static String passwordNueva = "98765";
    private static String repetirPasswordNueva = "98765";

    //Credenciales "Tester"
    private static String nombreTester = "Diego";
    private static String apellidoTester = "Rodriguez";
    private static String emailTester = "diego@gmail.com";
    private static String passwordTester = "1234567";


    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
    }

    @BeforeEach
    void beforeEach() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterEach
    void afterEach() {
        BrowserFactory.quitBrowser();
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    //Funcion aux para ingresar al sitio
    private void ingresarAPaginaAdminCES() {
        browser.interaction().navigateTo(url);
        browser.find().id("pass").write(hash);
        browser.find().xpath("//button[@type='submit']").click();
    }


    private void validarUrl(String urlEsperada) {
        String urlActual = browser.interaction().url();
        IVerify.create().verify(urlEsperada, urlActual, "No se encuentra en la página esperada.");
    }

    //Funcion auxiliar para Registro de usuario "Administraor"
    private void registrarUsuarioAdmin(String nombre, String apellido, String email, String password, String repetirPassword, String pais) {
        browser.find().link("REGISTRARSE").click();
        browser.find().xpath("//input[@name='inputFirstName']").write(nombre);
        browser.find().xpath("//input[@name='inputLastName']").write(apellido);
        browser.find().xpath("//input[@name='inputEmail']").write(email);
        browser.find().xpath("//input[@name='inputPassword']").write(password);
        browser.find().xpath("//input[@name='inputRepeatPassword']").write(repetirPassword);
        browser.find().xpath("//input[@name='inputCountry']").write(pais);
        browser.find().id("btnRegister").click();
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();
    }

    //Funcion auxiliar para ingreso e usuario Admin
    private void ingresoUsuarioAdmin(String emailAdmin, String passwordAdmin) {
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailAdmin);
        browser.find().xpath("//input[@name='inputPassword']").write(passwordAdmin);
        browser.find().css("button.btn.btn-orange-ces").click();
        browser.find().css("button.swal2-confirm").click();
    }

    private void ingresoCuentaPredeterminada(String emailPredeterminado, String passwordPredeterminada) {
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado);
        browser.find().xpath("//input[@name='inputPassword']").write(passwordPredeterminada);
        browser.find().xpath("//button[@type='button' and @class='btn btn-orange-ces rounded-end-pill btn-block']").click();
        browser.find().css("button.swal2-confirm").click();
    }

    //Funcion auxiliar para reiniciar contraseña
    private void reinicioPassword(String emailPredeterminado, String passwordNueva, String repetirpassworNueva){
        browser.find().link("REINICIAR CONTRASEÑA").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado);
        browser.find().xpath("//input[@name='inputPassword']").write(passwordNueva);
        browser.find().xpath("//input[@name='inputRepeatPassword']").write(repetirpassworNueva);
        browser.find().id("btnReset").click();
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();
    };

    private void crearUsuarioTester(String nombreTester, String apellidoTester, String emailTester, String pais, String passwordTester){
        browser.find().link("CREAR USUARIO").click();
        browser.find().xpath("//input[@name='inputFirstName']").write(nombreTester);
        browser.find().xpath("//input[@name='inputLastName']").write(apellidoTester);
        browser.find().xpath("//input[@name='inputEmail']").write(emailTester);
        browser.find().xpath("//select[@name='inputCountry']").selectValue(pais);
        browser.find().xpath("//input[@name='inputPassword']").write(passwordTester);
        browser.find().id("testerJunior").click();
        browser.find().id("btnRegister").click();
        browser.find().css("button.swal2-confirm").click();
    }




    @Test
    @Order(1)
    void CrearCuentaAdmin() {

        //Ingreso al sitio
        ingresarAPaginaAdminCES();

        //Validar la url
        validarUrl(url);

        //Creación de cuenta "Administrador"
        registrarUsuarioAdmin(nombre, apellido, emailAdmin, passwordAdmin, repetirPasswordAdmin, pais);


        //Inicio de sesion con cuenta "Administrador"
        ingresoUsuarioAdmin(emailAdmin, passwordAdmin);


        browser.find().xpath("//a[@data-bs-toggle='dropdown']").click();
        browser.find().xpath("//a[@href='/adminces/profile']").click();

        //Verificación de datos ingresados de cuenta "Administador"
        IVerify verify = IVerify.create();

        Element nombre = browser.find().name("inputFirstName");
        verify.verify("Mauro", nombre.getAttribute("value"), "El nombre no coincide.");

        Element apellido = browser.find().name("inputLastName");
        verify.verify("Roves", apellido.getAttribute("value"), "El apellido no coincide.");

        Element email = browser.find().name("inputEmail");
        verify.verify("mauro@gmail.com", email.getAttribute("value"), "El email no coincide.");

        Element pais = browser.find().name("inputCountry");
        verify.verify("Uruguay", pais.getAttribute("value"), "El país no coincide.");

        Element perfil = browser.find().css("input[value='Administrador']");
        verify.verify("Administrador", perfil.getAttribute("value"), "El perfil no coincide.");

        browser.find().css("a.sidebar-brand").click();

    }

    @Test
    @Order(2)
    void reiniciarPassword(){

        //Ingreso al sitio
        ingresarAPaginaAdminCES();

        //Validar la url
        validarUrl(url);

        //Reinicio de contraseña
        reinicioPassword(emailPredeterminado, passwordNueva, repetirPasswordNueva);

        //Probamos iniciar con la contraseña anterior
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado);
        browser.find().xpath("//input[@name='inputPassword']").write(passwordPredeterminada);
        browser.find().css("button.btn.btn-orange-ces.rounded-end-pill.btn-block").click();

        //Verificacion del mensaje "Sesión NO iniciada."
        Element mensajeNegativo = browser.find().id("swal2-html-container");
        IVerify.create().verify("Sesión NO iniciada.", mensajeNegativo.getText(), "El mensaje coincide");
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();

        //Verificamos el cambio de contraseña y el acceso con la contraseña nueva
        browser.find().xpath("//input[@name='inputEmail']").clear();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado);
        browser.find().xpath("//input[@name='inputPassword']").clear();
        browser.find().xpath("//input[@name='inputPassword']").write(passwordNueva);
        browser.find().css("button.btn.btn-orange-ces.rounded-end-pill.btn-block").click();
        Element mensajePositivo = browser.find().id("swal2-html-container");
        IVerify.create().verify("Sesión iniciada.", mensajePositivo.getText(), "El mensaje coincide");
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();

    }



    @Test
    @Order(3)
    void crearCuentaTester(){

        //Ingreso al sitio
        ingresarAPaginaAdminCES();

        //Validar la url
        validarUrl(url);

        //Iniciar sesion
        ingresoCuentaPredeterminada(emailPredeterminado, passwordPredeterminada);


        //Crear cuenta "Tester"
        crearUsuarioTester(nombreTester, apellidoTester, emailTester, pais, passwordTester);


        ////Verificación de datos ingresados de cuenta "Tester"
        browser.find().link("VER USUARIOS").click();
        IVerify verify = IVerify.create();

        Element tNombre = browser.find().xpath("//td[text()=\"diego@gmail.com\"]/preceding-sibling::td[2]");
        verify.verify("Diego", tNombre.getText(), "El email no coincide.");

        Element tApellido = browser.find().xpath("//td[text()=\"diego@gmail.com\"]/preceding-sibling::td[1]");
        verify.verify("Rodriguez", tApellido.getText(), "El email no coincide.");

        Element tMail = browser.find().xpath("//td[text()=\"diego@gmail.com\"]");
        verify.verify("diego@gmail.com", tMail.getText(), "El email no coincide.");

        Element tPais = browser.find().xpath("//td[text()='diego@gmail.com']/following-sibling::td[1]");
        verify.verify("Uruguay", tPais.getText(), "El email no coincide.");

        Element tPerfil = browser.find().xpath("//td[text()='diego@gmail.com']/following-sibling::td[2]");
        verify.verify("Tester Junior", tPerfil.getText(), "El email no coincide.");


    }

    @Test
    @Order(4)
    void eliminarCuentaTester(){

        //Ingreso al sitio
        ingresarAPaginaAdminCES();

        //Validar la url
        validarUrl(url);

        //Eliminar usuario Tester
        browser.find().link("INICIAR SESIÓN").click();
        browser.find().xpath("//input[@name='inputEmail']").write(emailPredeterminado);
        browser.find().xpath("//input[@name='inputPassword']").write(passwordPredeterminada);
        browser.find().css("button.btn.btn-orange-ces.rounded-end-pill.btn-block").click();
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();

        //Eliminar usuario Tester
        browser.find().link("VER USUARIOS").click();
        browser.find().id("dardo@gmail.com").click();
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();


        ////Verificación de eliminación de usuario "Tester"
        boolean existeTester;
        try {
            browser.find().xpath("//td[text()='" + "dardo@gmail.com" + "']").getText();
            existeTester = true;
        } catch (Exception e) {
            existeTester = false;
        }

        IVerify verify = IVerify.create();
        verify.verifyFalse(existeTester, "El usuario Tester sigue apareciendo en la lista.");


    }

}

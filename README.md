# Estructura del proyecto

## Interfaces

| Entidad  | Descripción                                                                                                       |
|----------|-------------------------------------------------------------------------------------------------------------------|
| IBrowser | Interfaz que define operaciones comunes para la gestión del navegador y la espera de elementos en una página web. |
| IVerify  | Interfaz que define métodos para verificar resultados esperados con obtenidos y agregar mensajes asociados.       |

## Patrones aplicados

| Patrón     | Entidad                 | Descripción                                                               |
|------------|-------------------------|---------------------------------------------------------------------------|
| Factory    | DriverManagerFactory    | Clase encargada de indicar que driver se debe retornar.                   |
| Singlenton | DriverManagerSinglenton | Clase encargada de mantener una sola instancia configurada con un driver. |


9/21/2026 - Semana 5 TATF

Dentro de la clase AdmCES se agregaron las 4 pruebas solicitadas siguiendo el guion previamente entregado (el cual fue modificado):

Crear cuenta de administrador.
Reiniciar contraseña.
Crear cuenta tester.
Eliminar cuenta Tester.

Para las pruebas se generaron las respectivas funciones auxiliares y valiaciones

Funciones aux:

ingresarAPaginaAdminCES() : ingreso al sitio
validarUrl() : validacion URL sitio
registrarUsuarioAdmin() : Funcion auxiliar para Registro de usuario "Administraor"
ingresoUsuarioAdmin() : Funcion auxiliar para ingreso e usuario Admin
ingresoCuentaPredeterminada() : Funcion auxiliar para ingresar con cuenta predeterminada o de prueba
reinicioPassword() : Funcion auxiliar para reiniciar contraseña
crearUsuarioTester() : Funcion auxiliar para crear un usuario del tipo "Tester"

9/25/2026 - 9/29/2026

Se aplica el metodo POM sobre los Test realizados en la semana 6.

10/4/2026

se realizan cambios segun retroalimentacion
se agrega parametrizacion a los 4 test respectivos a la tarea. (se crean los archivos crearCuenta.csv, eliminarTester.csv, registroAdmin.csv, reinicarPass.csv)
Los nuevos cambios se encuentran dentro del branch de la semana pasada "semana6"

10/11/2026

Se agregan datos a los archivos crearCuenta.csv, eliminarTester.csv, registroAdmin.csv, reinicarPass.csv

Se instalan las dependencias necesarias paa poder generar las suites

Se agrega la clase "ConfigReader"
Se agrega "Firefox Driver" para poder ejectuar pruebas en Mozilla Firefox
Se agrega el archivo config.properties
Se modifica la clase "BrowserFactory"

Se instalan las dependencias necesarias para poder generar los reportes en Allure

Se crean las suite:
    "FlujoCompleto":se encarga de probar los 4 test hasta el momento, Crear cuenta Admin, Crear cuenta Tester, Reiniciar Contraseña, Borrar usuario Tester.
    Actua seleccionando por package

    "ModificacionUsuarios": se encarga de probar lo referente a modificaciones, Reiniciar Contraseña, Borrar usuario Tester.
    Actua seleccionando por package y tags

    "RegistroUsuarios": se encarga de probar lo referente a registros, Crear cuenta Admin, Crear cuenta Tester.
    Actua seleccionando por clase

    "CrearEliminar": se encarga de probar crear y elimina un usuaio Tester
    Actua seleccionando por package y tag (include y exclude)
    
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
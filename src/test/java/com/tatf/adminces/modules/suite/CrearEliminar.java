package com.tatf.adminces.modules.suite;


import org.junit.platform.suite.api.*;

//Suite inicializada por tags y paquetes
@Suite
@SuiteDisplayName("Creacion y eliminacion de usuaio Tester")
@SelectPackages({
        "com.tatf.adminces.modules.crearCuentaTester.test",
        "com.tatf.adminces.modules.verUsuarios.test"
})
@IncludeTags("usuarios")
@ExcludeTags({"reiniciar-password", "registro-admin"})

public class CrearEliminar {
}

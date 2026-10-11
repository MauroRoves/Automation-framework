package com.tatf.adminces.modules.suite;


import org.junit.platform.suite.api.*;

//Suite inicializada por paquetes
@Suite
@SuiteDisplayName("Flujo Completo")
@SelectPackages({
        "com.tatf.adminces.modules.registroAdmin.test",
        "com.tatf.adminces.modules.reiniciarPass.test",
        "com.tatf.adminces.modules.crearCuentaTester.test",
        "com.tatf.adminces.modules.verUsuarios.test",
})


public class FlujoCompleto {
}

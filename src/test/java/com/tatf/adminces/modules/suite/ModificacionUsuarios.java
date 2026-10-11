package com.tatf.adminces.modules.suite;


import org.junit.platform.suite.api.*;

//Suite inicializada por tags y paquetes
@Suite
@SuiteDisplayName("Modificacion y eliminacion de usuarios")
@SelectPackages({
        "com.tatf.adminces.modules.reiniciarPass.test",
        "com.tatf.adminces.modules.verUsuarios.test"
})
@IncludeTags({"eliminar-usuarios","reiniciar-password"})

public class ModificacionUsuarios {

}

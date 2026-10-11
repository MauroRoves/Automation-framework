package com.tatf.adminces.modules.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import com.tatf.adminces.modules.crearCuentaTester.test.CrearCuentaTesterTest;
import com.tatf.adminces.modules.registroAdmin.test.RegistroAdminTest;

//Suite inicializada por clase
@Suite
@SuiteDisplayName("Registro de usuarios")
@SelectClasses({RegistroAdminTest.class, CrearCuentaTesterTest.class})
public class RegistroUsuarios {
}

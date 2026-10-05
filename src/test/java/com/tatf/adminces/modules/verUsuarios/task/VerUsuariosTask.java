package com.tatf.adminces.modules.verUsuarios.task;

import com.tatf.adminces.modules.verUsuarios.pom.VerUsuariosPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.adminces.modules.popUp.pom.PopUPPO;

public class VerUsuariosTask {
    private final VerUsuariosPO verUsuarios;
    private final PopUPPO popup;

    public VerUsuariosTask(IBrowser browser) {
        this.verUsuarios = new VerUsuariosPO(browser);
        this.popup = new PopUPPO(browser);
    }

    public void verificarUsuarioEnLista(String email, String nombreEsperado, String apellidoEsperado, String paisEsperado, String perfilEsperado) {
        IVerify verify = IVerify.create();
        verify.verify(nombreEsperado, this.verUsuarios.getNombrePorEmail(email), "El nombre no coincide.");
        verify.verify(apellidoEsperado, this.verUsuarios.getApellidoPorEmail(email), "El apellido no coincide.");
        verify.verify(email, this.verUsuarios.getEmailEnTabla(email), "El email no coincide.");
        verify.verify(paisEsperado, this.verUsuarios.getPaisPorEmail(email), "El país no coincide.");
        verify.verify(perfilEsperado, this.verUsuarios.getPerfilPorEmail(email), "El perfil no coincide.");
    }

    public void eliminarUsuarioTester(String email) {
        this.verUsuarios.clickEliminar(email);
        this.popup.confirmar();
        this.popup.confirmar();
    }

    public void verificarUsuarioEliminado(String email) {
        IVerify.create().verifyFalse(this.verUsuarios.existeUsuario(email), "El usuario Tester sigue apareciendo en la lista.");
    }
}

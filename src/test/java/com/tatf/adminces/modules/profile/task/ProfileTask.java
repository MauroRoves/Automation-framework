package com.tatf.adminces.modules.profile.task;

import com.tatf.adminces.modules.profile.pom.ProfilePO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class ProfileTask {
    private final IBrowser browser;

    private final ProfilePO profilePO;

    public ProfileTask(IBrowser browser) {
        this.browser = browser;
        this.profilePO = new ProfilePO(browser);
    }

    public void verificarDatosAdmin(String nombre, String apellido, String email, String pais, String perfilEsperado) {
        IVerify verify = IVerify.create();
        verify.verify(nombre, this.profilePO.getNombre(), "El nombre no coincide.");
        verify.verify(apellido, this.profilePO.getApellido(), "El apellido no coincide.");
        verify.verify(email, this.profilePO.getEmail(), "El email no coincide.");
        verify.verify(pais, this.profilePO.getPais(), "El país no coincide.");
        verify.verify(perfilEsperado, this.profilePO.getPerfil(), "El perfil no coincide.");
    }
}

package com.tatf.adminces.modules.login.data;

import com.tatf.core.util.ConfigReader;

public class LoginData {
    private static final ConfigReader CREDENTIALS = new ConfigReader("config.properties");

    // Cuenta predeterminada
    public static final String PREDETERMINADA_EMAIL = CREDENTIALS.asString("adminces.default_email");
    public static final String PREDETERMINADA_PASSWORD = CREDENTIALS.asString("adminces.default_password");

}
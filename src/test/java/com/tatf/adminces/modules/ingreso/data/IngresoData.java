package com.tatf.adminces.modules.ingreso.data;

import com.tatf.core.util.ConfigReader;

public class IngresoData {
    private static final ConfigReader CONFIG = new ConfigReader("config.properties");

    public static final String URL_ESPERADA = CONFIG.asString("adminces.url");
    public static final String HASH = CONFIG.asString("adminces.hash");

}
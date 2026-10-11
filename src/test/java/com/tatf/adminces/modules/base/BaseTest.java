package com.tatf.adminces.modules.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected static IBrowser browser;


    @BeforeEach
    public void configuration() {
        browser = BrowserFactory.getBrowser();
    }

    @AfterEach
    public void cerrar() {
        BrowserFactory.quitBrowser();
    }

}
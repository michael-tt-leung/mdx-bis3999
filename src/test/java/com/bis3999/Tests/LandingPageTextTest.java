package com.bis3999.Tests;

import com.bis3999.Pages.*;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;

import static org.junit.Assert.*;

public class LandingPageTextTest extends TestBase {

    public LandingPageTextTest(String os,
                          String version, String browser, String deviceName, String deviceOrientation) {
            super(os, version, browser, deviceName, deviceOrientation);
    }

    /**
     * Runs a simple test verifying link can be followed.
     * @throws InvalidElementStateException
     */
    @Test
    public void verifyHelloWorldTest() throws InvalidElementStateException {
        landingPage page = landingPage.visitPage(driver);
		
        assertFalse(page.hasHelloWorld());
    }
}
package com.bis3999.Tests;

import com.bis3999.Pages.landingPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

public class LandingPageTextTest extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "sauceBrowserDataProvider")
    public void verifyHelloWorldTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

		landingPage page = landingPage.visitPage(driver);
		System.out.println(page.getH2());
		//System.out.println(page.hasHelloWorld());
        //Assert.assertTrue(page.hasHelloWorld());
		Assert.assertEquals(page.getH2(), "Hello World!", "The page heading is not showing 'Hello World!'");
		
		String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
		(((RemoteWebDriver) driver).getSessionId()).toString(), "LandingPageTextTest");
		System.out.println(message);
    }
}
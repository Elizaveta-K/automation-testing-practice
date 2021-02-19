package eshop;

import infrastructure.base.TestBase;
import infrastructure.logger.StdTestLogger;
import infrastructure.logger.TestLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projects.eshop.pageFactory.LoginPage;
import projects.eshop.pageFactory.MainPage;
import projects.eshop.pageFactory.MyAccountPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PageFactoryLoginTests extends TestBase {

    private WebDriver webDriver;
    private TestLogger logger;

    private MainPage mainPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;


    @Before
    public void before(){
        webDriver = new ChromeDriver();
        logger = new StdTestLogger();

        logger.log("Open website");
        mainPage = new MainPage(webDriver);
        webDriver.get("http://automationpractice.com/");

        logger.log("Click Sign In link");
        mainPage.clickLoginLink();

        loginPage = new LoginPage(webDriver);

        myAccountPage = new MyAccountPage(webDriver);

    }

    @After
    public void after(){
        if (webDriver != null){
            webDriver.quit();
        }
    }

    @Test
    public void testSuccessfulLogin(){
        logger.log("Enter email");
        loginPage.enterEmail("blablatest@test.com");

        logger.log("Enter password");
        loginPage.enterPassword("qwerty");

        logger.log("Click Sign In button");
        loginPage.clickLoginButton();

        logger.log("Check My Account page");
        assertTrue(myAccountPage.isUserNamePresent("Lara Croft"));
        assertTrue(myAccountPage.isPageHeadingPresent());
        assertTrue(myAccountPage.isOrderHistoryAndDetailsPresent());
        assertTrue(myAccountPage.isMyCreditSlipsPresent());
        assertTrue(myAccountPage.isMyAddressesPresent());
        assertTrue(myAccountPage.isMyPersonalInfoPresent());
        assertTrue(myAccountPage.isMyWishListsPresent());

    }

    @Test
    public void testEmptyEmailAndPassword(){
        logger.log("Click Sign In button");
        loginPage.clickLoginButton();

        logger.log("Check error message");
        assertTrue(loginPage.isErrorMessagePresent());
        assertEquals("There is 1 error", loginPage.getGeneralErrorMessage());
        assertEquals("An email address required.", loginPage.getSpecificErrorMessage());
    }

    @Test
    public void testIncorrectEmail(){
        logger.log("Enter incorrect email");
        loginPage.enterEmail("test");

        logger.log("Click Sign In button");
        loginPage.clickLoginButton();

        logger.log("Check error message");
        assertTrue(loginPage.isErrorMessagePresent());
        assertEquals("There is 1 error", loginPage.getGeneralErrorMessage());
        assertEquals("Invalid email address.", loginPage.getSpecificErrorMessage());
    }

    @Test
    public void testIncorrectPassword(){
        logger.log("Enter email");
        loginPage.enterEmail("blablatest@test.com");

        logger.log("Enter incorrect password");
        loginPage.enterPassword("test");

        logger.log("Click Sign In button");
        loginPage.clickLoginButton();

        logger.log("Check error message");
        assertTrue(loginPage.isErrorMessagePresent());
        assertEquals("There is 1 error", loginPage.getGeneralErrorMessage());
        assertEquals("Invalid password.", loginPage.getSpecificErrorMessage());
    }

}

package eshop;

import infrastructure.base.TestBase;
import infrastructure.logger.StdTestLogger;
import infrastructure.logger.TestLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projects.eshop.pageObjects.LoginPage;
import projects.eshop.pageObjects.MainPage;
import projects.eshop.pageObjects.MyAccountPage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PageObjectLoginTests extends TestBase {

    private WebDriver webDriver;
    private TestLogger logger;

    private MainPage mainPage;

    @Before
    public void before(){
        webDriver = new ChromeDriver();
        logger = new StdTestLogger();

        mainPage = new MainPage(webDriver, logger);
    }

    @After
    public void after(){
        if (webDriver != null){
            webDriver.quit();
        }
    }

    @Test
    public void testSuccessfulLogin(){

        MyAccountPage myAccountPage = mainPage
                .open()
                .clickLoginLink()
                .enterEmail("blablatest@test.com")
                .enterPassword("qwerty")
                .clickLoginButton();

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
        LoginPage page = mainPage
                .open()
                .clickLoginLink()
                .clickFailLoginButton();

        assertTrue(page.isErrorMessagePresent());
        assertEquals("There is 1 error", page.getGeneralErrorMessage());
        assertEquals("An email address required.",page.getSpecificErrorMessage());
    }

    @Test
    public void testIncorrectEmail(){
        LoginPage page = mainPage
                .open()
                .clickLoginLink()
                .enterEmail("test")
                .clickFailLoginButton();

        assertTrue(page.isErrorMessagePresent());
        assertEquals("There is 1 error", page.getGeneralErrorMessage());
        assertEquals("Invalid email address.",page.getSpecificErrorMessage());
    }

    @Test
    public void testIncorrectPassword(){
        LoginPage page = mainPage
                .open()
                .clickLoginLink()
                .enterEmail("blablatest@test.com")
                .enterPassword("test")
                .clickFailLoginButton();

        assertTrue(page.isErrorMessagePresent());
        assertEquals("There is 1 error", page.getGeneralErrorMessage());
        assertEquals("Invalid password.",page.getSpecificErrorMessage());
    }

}

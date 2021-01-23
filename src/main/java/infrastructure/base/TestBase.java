package infrastructure.base;

import infrastructure.logger.TestLogger;
import infrastructure.utils.TestUrl;
import infrastructure.wdm.DefaultWebDriverManager;
import infrastructure.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TestBase {
    protected TestLogger logger;
    private WebDriverManager wdm;
    protected WebDriver browser;

    public void startUp(){

        logger = new TestLogger();

        logger.log("Launch browser");
        wdm = new DefaultWebDriverManager();

        //browser = wdm.createBrowser();
        browser = wdm.getBrowser();

        logger.log("Open website");
        System.out.println("--> " + browser + " opening " + TestUrl.editorUrl());


        beforeTest();
    }

    public void cleanUp(){
        afterTest();

        //wdm.closeBrowser(browser);
        wdm.destroyBrowser(browser);
    }

    protected void beforeTest(){
        System.out.println("-----------> DEFAULT BEFORE TEST");
    }

    protected void afterTest(){
        System.out.println("-----------> DEFAULT AFTER TEST");
    }
}

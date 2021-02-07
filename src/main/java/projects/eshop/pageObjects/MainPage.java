package projects.eshop.pageObjects;

import infrastructure.logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver webDriver;
    TestLogger logger;

    public MainPage(WebDriver webDriver, TestLogger logger) {
        this.webDriver = webDriver;
        this.logger = logger;
    }

    public MainPage open(){
        logger.log("Open main page");
        webDriver.get("http://automationpractice.com/");

        return this;
    }

    public LoginPage clickLoginLink(){
        logger.log("Click Sign in link");
        WebElement loginLink = webDriver.findElement(By.className("login"));
        loginLink.click();

        return new LoginPage(webDriver, this.logger);
    }
}

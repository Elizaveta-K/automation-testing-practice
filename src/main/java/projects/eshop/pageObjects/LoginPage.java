package projects.eshop.pageObjects;

import infrastructure.logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver webDriver;
    TestLogger logger;

    public LoginPage(WebDriver webDriver, TestLogger logger) {
        this.webDriver = webDriver;
        this.logger = logger;
    }

    public LoginPage enterEmail(String email){
        logger.log("Enter email");
        WebElement userEmailInput = webDriver.findElement(By.id("email"));
        userEmailInput.click();
        userEmailInput.clear();
        userEmailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        logger.log("Enter password");
        WebElement userPwdInput = webDriver.findElement(By.id("passwd"));
        userPwdInput.click();
        userPwdInput.clear();
        userPwdInput.sendKeys(password);
        return this;
    }

    public MyAccountPage clickLoginButton(){
        clickLogin();
        return new MyAccountPage(webDriver, this.logger);
    }

    public LoginPage clickFailLoginButton(){
        clickLogin();
        return this;
    }

    private void clickLogin(){
        logger.log("Click Sign in button");
        WebElement loginButton = webDriver.findElement(By.id("SubmitLogin"));
        loginButton.click();
    }

    public Boolean isErrorMessagePresent(){
        return webDriver.findElement(By.cssSelector(".alert.alert-danger")).isDisplayed();
    }

    public String getGeneralErrorMessage(){
        WebElement alertDanger = webDriver.findElement(By.cssSelector(".alert.alert-danger"));
        return alertDanger.findElement(By.tagName("p")).getText();
    }

    public String getSpecificErrorMessage(){
        WebElement alertDanger = webDriver.findElement(By.cssSelector(".alert.alert-danger"));
        return alertDanger.findElement(By.tagName("li")).getText();
    }


}

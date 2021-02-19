package projects.eshop.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(css = ".alert.alert-danger")
    private WebElement alertDanger;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(this.webDriver, this);
    }

    public void enterEmail(String email){
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public Boolean isErrorMessagePresent(){
        return alertDanger.isDisplayed();
    }

    public String getGeneralErrorMessage(){
        return alertDanger.findElement(By.tagName("p")).getText();
    }

    public String getSpecificErrorMessage(){
        return alertDanger.findElement(By.tagName("li")).getText();
    }
}

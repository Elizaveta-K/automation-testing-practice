package projects.eshop.pageObjects;

import infrastructure.logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MyAccountPage {
    WebDriver webDriver;
    TestLogger logger;

    public MyAccountPage(WebDriver webDriver, TestLogger logger) {
        this.webDriver = webDriver;
        this.logger = logger;
    }

    public Boolean isUserNamePresent(String userName){
        WebElement userInfo = webDriver.findElement(By.className("header_user_info"));
        return userInfo.findElement(By.tagName("span")).getText().equals(userName);
    }

    public Boolean isOrderHistoryAndDetailsPresent(){
        List<WebElement> links;
        links = webDriver.findElements(By.tagName("a"));
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=history")){
                return true;
            }
        }
        return false;
    }

    public Boolean isPageHeadingPresent(){
        WebElement heading = webDriver.findElement(By.className("page-heading"));
        if(heading.getText().equals("MY ACCOUNT")){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isMyCreditSlipsPresent(){
        List<WebElement> links = new ArrayList<>();
        links = webDriver.findElements(By.tagName("a"));
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=order-slip")){
                return true;
            }
        }
        return false;
    }

    public Boolean isMyAddressesPresent(){
        List<WebElement> links = new ArrayList<>();
        links = webDriver.findElements(By.tagName("a"));
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=addresses")){
                return true;
            }
        }
        return false;
    }

    public Boolean isMyPersonalInfoPresent(){
        List<WebElement> links = new ArrayList<>();
        links = webDriver.findElements(By.tagName("a"));
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=identity")){
                return true;
            }
        }
        return false;
    }

    public Boolean isMyWishListsPresent(){
        List<WebElement> links = new ArrayList<>();
        links = webDriver.findElements(By.tagName("a"));
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist")){
                return true;
            }
        }
        return false;
    }
}

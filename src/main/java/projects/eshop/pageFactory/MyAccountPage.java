package projects.eshop.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage {

    private WebDriver webDriver;

    @FindBy(className = "header_user_info")
    private WebElement userInfo;

    @FindBy(className = "page-heading")
    private WebElement heading;

    @FindBy(tagName = "a")
    private List<WebElement> links = new ArrayList<>();

    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(this.webDriver, this);
    }

    public Boolean isUserNamePresent(String userName){
        return userInfo.findElement(By.tagName("span")).getText().equals(userName);
    }

    public Boolean isOrderHistoryAndDetailsPresent(){
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=history")){
                return true;
            }
        }
        return false;
    }

    public Boolean isPageHeadingPresent(){
        if(heading.getText().equals("MY ACCOUNT")){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isMyCreditSlipsPresent(){
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=order-slip")){
                return true;
            }
        }
        return false;
    }

    public Boolean isMyAddressesPresent(){
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=addresses")){
                return true;
            }
        }
        return false;
    }

    public Boolean isMyPersonalInfoPresent(){
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?controller=identity")){
                return true;
            }
        }
        return false;
    }

    public Boolean isMyWishListsPresent(){
        for(WebElement link: links){
            if(link.getAttribute("href").equals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist")){
                return true;
            }
        }
        return false;
    }
}

package infrastructure.wdm.factories;

import infrastructure.config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocalWebDriverFactory implements WebDriverFactory{

    @Override
    public WebDriver create() {
        switch(ConfigurationManager.getInstance().getTestBrowser()){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
            default:
                return new FirefoxDriver();
            case "ie":
                return new InternetExplorerDriver();
        }
    }
}

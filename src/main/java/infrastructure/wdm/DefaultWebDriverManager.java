package infrastructure.wdm;

import infrastructure.config.ConfigurationManager;
import infrastructure.wdm.factories.CloudWebDriverFactory;
import infrastructure.wdm.factories.LocalWebDriverFactory;
import infrastructure.wdm.factories.RemoteWebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManager{
    @Override
    public WebDriver getBrowser() {
        switch(ConfigurationManager.getInstance().getRunOn()){
            case "cloud":
                return new CloudWebDriverFactory().create();
            case "remote":
                return new RemoteWebDriverFactory().create();
            case "local":
            default:
                return new LocalWebDriverFactory().create();
        }
    }

    @Override
    public void destroyBrowser(WebDriver browser) {
        System.out.println("Closing browser: " + browser);
        browser.quit();
    }
}

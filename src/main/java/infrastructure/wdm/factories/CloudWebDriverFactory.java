package infrastructure.wdm.factories;

import infrastructure.config.ConfigurationManager;
import infrastructure.wdm.PlatformCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudWebDriverFactory implements WebDriverFactory{
    private final String SAUCE_USERNAME = System.getenv("sauceUsername");
    private final String SAUCE_ACCESS_KEY = System.getenv("sauceAccessKey");


    private URL cloudUrl;

    {
        try {
            cloudUrl = new URL("https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "https://eu-central-1.saucelabs.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    DesiredCapabilities capabilities = new PlatformCapabilities();


    @Override
    public RemoteWebDriver create() {
        switch(ConfigurationManager.getInstance().getTestBrowser()){
            case "chrome":
                capabilities.setBrowserName("Chrome");
                return new RemoteWebDriver(cloudUrl, capabilities);
            case "firefox":
                capabilities.setBrowserName("Firefox");
                return new RemoteWebDriver(cloudUrl, capabilities);
            case "ie":
                capabilities.setBrowserName("IE");
                return new RemoteWebDriver(cloudUrl, capabilities);
            default:
                return new RemoteWebDriver(cloudUrl, capabilities);
        }
    }
}

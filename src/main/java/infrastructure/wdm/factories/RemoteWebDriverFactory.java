package infrastructure.wdm.factories;

import infrastructure.config.ConfigurationManager;
import infrastructure.wdm.BrowserCapabilities;
import infrastructure.wdm.factories.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory implements WebDriverFactory {

    private DesiredCapabilities capabilities = new BrowserCapabilities();
    private URL remoteUrl;

    {
        try {
            remoteUrl = new URL("http://www.example.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public RemoteWebDriver create() {
        switch(ConfigurationManager.getInstance().getTestBrowser()){
            case "chrome":
                capabilities.setBrowserName("Chrome");
                return new RemoteWebDriver(remoteUrl, capabilities);
            case "firefox":
                capabilities.setBrowserName("Firefox");
                return new RemoteWebDriver(remoteUrl, capabilities);
            case "ie":
                capabilities.setBrowserName("IE");
                return new RemoteWebDriver(remoteUrl, capabilities);
            default:
                return new RemoteWebDriver(remoteUrl, capabilities);
        }
    }
}

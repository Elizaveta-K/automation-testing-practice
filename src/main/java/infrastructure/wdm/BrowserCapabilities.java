package infrastructure.wdm;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapabilities extends DesiredCapabilities {

    private DesiredCapabilities browserCapabilities;

    public BrowserCapabilities() {

        browserCapabilities = new DesiredCapabilities();
        browserCapabilities.setBrowserName("Chrome");
        browserCapabilities.acceptInsecureCerts();
        browserCapabilities.setJavascriptEnabled(true);
        browserCapabilities.setPlatform(Platform.WINDOWS);
        browserCapabilities.setVersion("latest");
    }
}

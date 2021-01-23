package infrastructure.wdm;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformCapabilities extends DesiredCapabilities {
    private DesiredCapabilities platformCapabilities;

    public PlatformCapabilities() {

        platformCapabilities = new DesiredCapabilities();
        platformCapabilities.setCapability("platform", Platform.WINDOWS);
        platformCapabilities.setCapability("browserName", "Chrome");
        platformCapabilities.setCapability("version", "latest");
    }
}

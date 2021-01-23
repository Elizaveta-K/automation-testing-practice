package unitTests.configTests;

import infrastructure.config.ConfigurationManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigurationManagerTests {

    @Test
    public void testGetBrowser(){
        String configuredBrowser = ConfigurationManager.getInstance().getTestBrowser();

        assertEquals("chrome", configuredBrowser);
    }

    @Test
    public void testGetTestEnv(){
        String configuredTestEnv = ConfigurationManager.getInstance().getTestEnv();

        assertEquals("staging", configuredTestEnv);
    }

    @Test
    public void testGetLogType(){
        String configuredLogType = ConfigurationManager.getInstance().getLogType();

        assertEquals("std", configuredLogType);
    }

    @Test
    public void testGetRunOn(){
        String configuredRunOn =  ConfigurationManager.getInstance().getRunOn();

        assertEquals("local", configuredRunOn);
    }

    @Test
    public void testGetLanguage(){
        String configuredLanguage = ConfigurationManager.getInstance().getLanguage();

        assertEquals("en", configuredLanguage);
    }
}

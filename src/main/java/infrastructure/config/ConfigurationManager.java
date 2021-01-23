package infrastructure.config;

public class ConfigurationManager {
    private ConfigurationManager() {
    }

    private static class SingletonHolder {
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    public static ConfigurationManager getInstance () {
        return SingletonHolder.INSTANCE;
    }

    public String getTestBrowser(){
        return getEnvironmentVariableOrDefault("testBrowser", "chrome");
    }

    public String getTestEnv(){
        return getEnvironmentVariableOrDefault("testEnv", "staging");
    }

    public String getLogType(){
        return getEnvironmentVariableOrDefault("logType", "std");
    }

    public String getRunOn(){
        return getEnvironmentVariableOrDefault("runOn", "local");
    }

    public String getLanguage() { return getEnvironmentVariableOrDefault("testLang", "en");}

    private String getEnvironmentVariableOrDefault (String envVar, String defaultValue){
        return System.getenv(envVar) == null || System.getenv(envVar).isBlank() ?
                defaultValue :
                System.getenv(envVar);
    }
}

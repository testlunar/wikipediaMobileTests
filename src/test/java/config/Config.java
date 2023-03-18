package config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:${env}.properties",
                "classpath:loginData.properties"})
public interface Config extends org.aeonbits.owner.Config {

    @Key("mobile.version")
    String mobileVersion();

    @Key("mobile.device")
    String mobileDevice();

    @Key("mobile.appPackage")
    String mobileAppPackage();

    @Key("mobile.appActivity")
    String mobileAppActivity();

    @Key("mobile.appPath")
    String mobileAppPath();

    @Key("mobile.appURL")
    String mobileAppURL();

    @Key("mobile.url")
    String mobileUrl();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();
}

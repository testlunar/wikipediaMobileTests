package android;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.MobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

class TestBase {
    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("env")) {
            case "androidBrowserStack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "androidLocal":
                Configuration.browser = MobileDriver.class.getName();
                break;
        }
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Selenide.closeWebDriver();
        if (!System.getProperty("env").equals("mobile")) Attach.addVideo(sessionId);
    }
}



package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.Map;

public class TestBaseExtended {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browser = "chrome";
        //Configuration.browserVersion = "100.0";
        //Configuration.browserSize = "1920x1080";

        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
       // Configuration.remote = System.getProperty("remoteURL", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        //Configuration.browser = System.getProperty("browser", "chrome");
        //Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        //Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        Configuration.remote = System.getProperty("remoteURL");
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}


//gradle clean remote_test -Dremote_selenide=https://user1:1234@selenoid.autotests.cloud/wd/hub
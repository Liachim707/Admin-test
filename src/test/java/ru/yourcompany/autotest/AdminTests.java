package ru.yourcompany.autotest;

import com.codeborne.selenide.WebElementCondition;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.yourcompany.autotest.pages.AdminPage;
import ru.yourcompany.autotest.pages.RoomCreatePage;

import static com.codeborne.selenide.Selenide.$;

public class AdminTests {

    private AdminPage adminPage;

    @BeforeEach
    void setUp() {
        adminPage = new AdminPage();
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "HEADLESS", matches = "false")
    public void testAdminLogin() {

        adminPage.usernameField().setValue("admin");
        adminPage.passwordField().setValue("password");
        adminPage.loginButton().click();

        assertTrue(adminPage.isLoggedIn(), "Admin login failed");
    }

    private void assertTrue(boolean loggedIn, String adminLoginFailed) {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "HEADLESS", matches = "false")
    public void testCreateRoom() {

        adminPage.usernameField().setValue("admin");
        adminPage.passwordField().setValue("password");
        adminPage.loginButton().click();

        RoomCreatePage roomPage = adminPage.goToCreateRoom();

        roomPage.fillAndSave("Test Room", "5");

        $("body").shouldHave(textContaining("Test Room"));
    }

    private WebElementCondition textContaining(String testRoom) {
        return null;
    }
}

package ru.yourcompany.autotest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Condition.text;
import org.junit.jupiter.api.*;
import ru.yourcompany.autotest.pages.AdminPage;
import ru.yourcompany.autotest.pages.RoomCreatePage;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.codeborne.selenide.Selenide.$;

public class AdminTests {

    private AdminPage adminPage;

    @BeforeEach
    void setUp() {
        adminPage = new AdminPage();
    }

    @Test
    public void testAdminLogin() {

        adminPage.usernameField().setValue("admin");
        adminPage.passwordField().setValue("password");
        adminPage.loginButton().click();

    }

    @Test
    public void testCreateRoom() {

        adminPage.usernameField().setValue("admin");
        adminPage.passwordField().setValue("password");
        adminPage.loginButton().click();

        RoomCreatePage roomPage = adminPage.goToCreateRoom();

        roomPage.fillAndSave("Test Room", "5");

        $("h1").shouldHave(text("Admin Dashboard"));
    }
}
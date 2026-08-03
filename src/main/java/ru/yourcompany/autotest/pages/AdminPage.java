package ru.yourcompany.autotest.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AdminPage {

    public static final String BASE_URL = "https://automationintesting.online/#/admin";

    public AdminPage() {
        open(BASE_URL);
        waitForAdminPage();
    }

    private void waitForAdminPage() {
        $("h1").shouldHave(textContaining("Admin Dashboard"));
    }

    private WebElementCondition textContaining(String adminDashboard) {
        return null;
    }

    public SelenideElement usernameField() {
        return $("#username");
    }

    public SelenideElement passwordField() {
        return $("#password");
    }

    public SelenideElement loginButton() {
        return $("#loginBtn");
    }

    public boolean isLoggedIn() {
        return $("h1").text().contains("Admin Dashboard");
    }

    public RoomCreatePage goToCreateRoom() {
        $("#room-create-link").click();
        return new RoomCreatePage();
    }
}

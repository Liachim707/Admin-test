package ru.yourcompany.autotest.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AdminPage {

    public static final String ADMIN_URL = "https://automationintesting.online/#/admin";

    public AdminPage openPage() {
        open(ADMIN_URL);
        $("#username").shouldBe(visible);
        $("#password").shouldBe(visible);
        $("#doLogin").shouldBe(visible);
        return this;
    }

    public AdminPage login(String username, String password) {
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("#doLogin").click();
        return this;
    }

    public AdminPage shouldBeLoggedIn() {
        $("h2").shouldHave(text("Rooms"));
        return this;
    }

    public RoomCreatePage roomForm() {
        return new RoomCreatePage();
    }
}

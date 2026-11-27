package ru.yourcompany.autotest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yourcompany.autotest.pages.AdminPage;
import ru.yourcompany.autotest.pages.RoomCreatePage;

import java.util.UUID;

class AdminTests {

    private AdminPage adminPage;

    @BeforeEach
    void setUp() {
        adminPage = new AdminPage().openPage();
    }

    private void loginAsAdmin() {
        adminPage.login("admin", "password").shouldBeLoggedIn();
    }

    @Test
    void adminCanLogIn() {
        loginAsAdmin();
    }

    @Test
    void adminCanCreateRoom() {
        loginAsAdmin();

        String roomName = "Test-Room-" + UUID.randomUUID().toString().substring(0, 8);
        RoomCreatePage roomPage = adminPage.roomForm();

        roomPage.createRoom(roomName, "Single", true, "120",
                "Room created by automated UI test");
        roomPage.shouldContainRoom(roomName);
    }
}

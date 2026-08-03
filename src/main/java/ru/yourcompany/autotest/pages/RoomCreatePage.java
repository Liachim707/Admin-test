package ru.yourcompany.autotest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RoomCreatePage {

    public SelenideElement roomNameField() {
        return $("#room-name");
    }

    public SelenideElement roomCapacityField() {
        return $("#room-capacity");
    }

    public SelenideElement saveButton() {
        return $(".btn-primary");
    }

    public void fillAndSave(String name, String capacity) {
        roomNameField().setValue(name);
        roomCapacityField().setValue(capacity);
        saveButton().click();
    }
}

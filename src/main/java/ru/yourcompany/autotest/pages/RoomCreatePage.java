package ru.yourcompany.autotest.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RoomCreatePage {

    public RoomCreatePage createRoom(String name, String type, boolean accessible,
                                     String price, String description) {
        $("#roomName").shouldBe(visible).setValue(name);
        $("#type").selectOption(type);

        if ($("#accessible").isSelected() != accessible) {
            $("#accessible").click();
        }

        $("#roomPrice").setValue(price);
        $("#description").setValue(description);

        // Кнопка создания расположена в форме добавления номера.
        $$("button").findBy(text("Create")).click();
        return this;
    }

    public void shouldContainRoom(String name) {
        $("#roomName" + name).shouldBe(visible);
    }
}

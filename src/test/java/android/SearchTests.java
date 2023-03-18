package android;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class SearchTests extends TestBase {

    @Test
    @Owner("Diana")
    @Tag("android")
    @DisplayName("Search article by name")
    void searchByWordTest() {
        step("Skip language choose", () -> {
            $(xpath("//*[contains(@text,'SKIP')]")).click();
            $(id("org.wikipedia:id/search_container")).click();
        });
        step("Type search 'Java'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });
        step("Verify that content is found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
        step("Verify the title is 'Object-oriented programming language'", () -> {
            $(xpath(" //*[contains(@text,'Object-oriented programming language')]"))
                    .shouldHave(exist);
        });
    }

    @Test
    @Owner("Diana")
    @Tag("android")
    @DisplayName("Cancel search by word")
    void cancelSearchTest() {
        step("Skip language choose", () -> {
            $(xpath("//*[contains(@text,'SKIP')]")).click();
        });
        step("Type search 'Java'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });
        step("Verify that content is found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Wait till 'Cancel' button appear", () ->
                $(id("org.wikipedia:id/search_close_btn"))
                        .shouldHave(exist, Duration.ofSeconds(5)));

        step("Click 'Cancel' button", () ->
                $(id("org.wikipedia:id/search_close_btn")).click());

        step("Wait till 'Cancel' button disappear", () ->
                $(id("org.wikipedia:id/search_close_btn"))
                        .shouldHave(not(visible), Duration.ofSeconds(5)));
    }
}

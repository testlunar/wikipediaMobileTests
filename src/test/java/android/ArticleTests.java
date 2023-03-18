package android;


import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ArticleTests {
    private static String title = "Object-oriented programming language";
    private static String listName = "Ne list";

    @Test
    @Owner("Diana")
    @Tag("android")
    @DisplayName("Compare article title")
    void testCancelSearchTest() {

        step("Skip language choose", () -> {
            $(xpath("//*[contains(@text,'SKIP')]")).click();
        });

        step("Type search 'Java'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Verify that content is found", () -> {
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0));
        });

        step("Click on article with title is" + title, () -> {
                $(xpath("//*[contains(@text,'" + title + "')]"))
                        .shouldHave(exist).click();
        });

        step("Check that title of article is" + title, () -> {
                $(xpath("//*[@resource-id='pcs-edit-section-title-description']/../android.widget.TextView[1]"))
                        .shouldHave(text(title));
        });
    }

    @Test
    @Owner("Diana")
    @Tag("android")
    @DisplayName("Add article to saved list")
    void addArticleToSavedListTest() {

        step("Skip language choose", () -> {
            $(xpath("//*[contains(@text,'SKIP')]")).click();
        });

        step("Type search 'Java'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Verify that content is found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });

        step("Click on article with title is" + title, () -> {
            $(xpath("//*[contains(@text,'" + title + "')]"))
                    .shouldHave(exist).click();
        });

        step("Click on save article button" , () -> {
            $(id("id:org.wikipedia:id/page_save"))
                    .shouldHave(exist).click();
        });

        step("Click on snackbar" , () -> {
            $(id("id:org.wikipedia:id/snackbar_action"))
                    .shouldHave(exist).click();
        });

        step("Add articlet to list with name " + listName, () -> {
            $(xpath("//*[contains(@text,'Name of this list')]"))
                    .shouldHave(exist).sendKeys(listName);

            $(xpath("//*[contains(@text,'OK')]"))
                    .shouldHave(exist).click();
        });

    }
}

package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class NewsCard extends BasePage {
    public static ViewInteraction newsCategoryImage = onView(withIndex(withId(R.id.category_icon_image_view), 0));
    public static ViewInteraction newsTitle = onView(withIndex(withId(R.id.news_item_title_text_view), 0));
    public static ViewInteraction newsDate = onView(withIndex(withId(R.id.news_item_date_text_view), 0));
    public static ViewInteraction newsDescription = onView(withIndex(withId(R.id.news_item_description_text_view), 0)); //view only on expand news


    public static void deleteButtonCheck() {
        Allure.step("Проверка наличия кнопки Удаление новости");
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).check(matches(isClickable()));
    }

    public static void editButtonCheck() {
        Allure.step("Проверка наличия кнопки Редактировать новость");
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).check(matches(isClickable()));
    }

    public static void statusButtonCheck() {
        Allure.step("Проверка наличия кнопки Изменение статуса");
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).check(matches(isDisplayed()));
    }

    public static void newsCardFullShortCheck() {
        Allure.step("Проверка содержимого карточки новости (свернутой)");
        newsTitle.check(matches(isDisplayed()));
        newsCategoryImage.check(matches(isDisplayed()));
        newsDate.check(matches(isDisplayed()));
        newsDescription.check(matches(not(isDisplayed())));
    }

    public static void newsCardFullCheck() {
        Allure.step("Проверка содержимого карточки новости");
        onView(withIndex(withId(R.id.category_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_publication_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_creation_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_create_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_author_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_author_name_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_published_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(isDisplayed()));

        onView(withIndex(withId(R.id.news_item_publication_text_view), 0)).check(matches(withText("Дата публикации")));
        onView(withIndex(withId(R.id.news_item_creation_text_view), 0)).check(matches(withText("Дата создания")));
        onView(withIndex(withId(R.id.news_item_author_text_view), 0)).check(matches(withText("Автор")));
    }

    public static void newsCardFullDescriptionsCheck() {
        Allure.step("Проверка содержимого карточки новости (свернутой)");
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }
}

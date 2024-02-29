package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class News extends BasePage {
    private static final ViewInteraction titleNewsHeader = onView(withText("Новости"));
    private static final ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    private static final ViewInteraction sorterButton = onView(withId(R.id.sort_news_material_button));
    private static final ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));
    private static final ViewInteraction addNewNewsButton = onView(withId(R.id.add_news_image_view));
    private static final ViewInteraction filterTitle = onView(withId(R.id.filter_news_title_text_view));
    private static final ViewInteraction filterCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private static final ViewInteraction filterDateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private static final ViewInteraction filterDateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    private static final ViewInteraction filterSubmitButton = onView(withId(R.id.filter_button));
    private static final ViewInteraction filterCancelButton = onView(withId(R.id.cancel_button));

    private static final ViewInteraction newDescriptionText = onView(withText("This my clever news"));

    public static void titleNewsHeaderCheck() {
        Allure.step("Проверка заголовка Новости");
        waitUntilElement("Новости");
        existText(titleNewsHeader, "Новости");
    }

    public static void filterButtonCheck() {
        Allure.step("Проверка кнопки");
        existClickable(filterButton);
    }

    public static void filterButtonClick() {
        Allure.step("Тап по кнопке");
        waitUntilElement(R.id.filter_news_material_button);
        filterButton.perform(click());
    }

    public static void sorterButtonCheck() {
        Allure.step("Проверка кнопки Сортировка");
        existClickable(sorterButton);
    }

    public static void controlPanelButtonCheck() {
        Allure.step("Проверка кнопки Контрольная панель");
        waitUntilElement(R.id.edit_news_material_button);
        existClickable(controlPanelButton);
    }

    public static void controlPanelButtonClick() {
        Allure.step("Тап по кнопке");
        waitUntilElement(R.id.edit_news_material_button);
        controlPanelButton.perform(click());
    }

    public static void addNewNewsButtonCheck() {
        Allure.step("Проверка кнопки");
        existClickable(addNewNewsButton);
    }

    public static void addNewNewsButtonClick() {
        Allure.step("Тап по кнопке");
        addNewNewsButton.perform(click());
    }

    public static void filterDateEndClick() {
        Allure.step("Тап по полю Date");
        waitUntilElement(R.id.news_item_publish_date_end_text_input_edit_text);
        filterDateEnd.perform(click());
    }

    public static void filterDateStartClick() {
        Allure.step("Тап по полю Date");
        waitUntilElement(R.id.news_item_publish_date_start_text_input_edit_text);
        filterDateStart.perform(click());
    }

    public static void swipeUpNewsBlock() {
        Allure.step("Swipe up");
        onView(withIndex(withId(R.id.news_item_title_text_view), 4)).perform(customSwipeUp());
    }

    public static void filterCategoryClick() {
        Allure.step("Тап по полю Категория");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        filterCategory.perform(click());
        pauseSSt();
        filterCategory.perform(closeSoftKeyboard());
    }

    public static void filterBaseCheck() {
        Allure.step("Проверка элементов на странице");
        waitUntilElement(R.id.filter_news_title_text_view);
        filterTitle.check(matches(isDisplayed()));
        filterTitle.check(matches(withText("Фильтровать новости")));
        filterCategory.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.text_input_end_icon), 0)).check(matches(isDisplayed()));
        filterDateStart.check(matches(isDisplayed()));
        filterDateEnd.check(matches(isDisplayed()));
        filterSubmitButton.check(matches(isDisplayed()));
        filterCancelButton.check(matches(isDisplayed()));

        filterCategory.check(matches(isClickable()));
        filterDateStart.check(matches(isClickable()));
        filterDateEnd.check(matches(isClickable()));
        filterSubmitButton.check(matches(isClickable()));
        filterCancelButton.check(matches(isClickable()));

        filterCategory.check(matches(withHint("Категория")));
        filterDateStart.check(matches(withHint("ДД.ММ.ГГГГ")));
        filterDateEnd.check(matches(withHint("ДД.ММ.ГГГГ")));
        filterSubmitButton.check(matches(withText("Фильтровать")));
        filterCancelButton.check(matches(withText("Отмена")));
    }


    public static void newsCardStdCheck() {
        Allure.step("Проверка содержимого карточки новости (свернутой)");
        onView(withIndex(withId(R.id.category_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(not(isDisplayed())));
    }

    public static void newsCardDescriptionsCheck() {
        Allure.step("Проверка содержимого карточки новости");
        waitUntilElement(R.id.news_item_title_text_view);
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        waitUntilElement(R.id.news_item_description_text_view);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    public static void shouldBeVisibleDescriptionText() {
        Allure.step("Проверка создания новости с описанием");
        waitUntilElement(R.id.news_item_title_text_view);
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        waitUntilElement(R.id.news_item_description_text_view);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
        waitUntilElement("This my clever news");
    }
}

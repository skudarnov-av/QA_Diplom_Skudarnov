package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;

public class NewsControl extends News {
    private static final ViewInteraction filterActiveSwitch = onView(withId(R.id.filter_news_active_material_check_box));
    private static final ViewInteraction filterInactiveSwitch = onView(withId(R.id.filter_news_inactive_material_check_box));
    private static final ViewInteraction controlPanelTitle = onView(withText("Панель \n управления"));


    public static void filterActiveSwitchCheck() {
        Allure.step("Кнопка отображается и кликабельна");
        existClickable(filterActiveSwitch);
    }

    public static void filterInactiveSwitchCheck() {
        Allure.step("Переключатель отображается и кликабелен");
        existClickable(filterInactiveSwitch);
    }

    public static void filterActiveChecked() {
        Allure.step("Кнопка отображается и кликабельна");
        filterActiveSwitch.check(matches(isChecked()));
    }

    public static void filterInactiveSwitchChecked() {
        Allure.step("Переключатель отображается и кликабелен");
        filterInactiveSwitch.check(matches(isChecked()));
    }

    public static void editButtonClick() {
        Allure.step("Тап по кнопке edit");
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
    }
    public static void controlPanelTitleCheck(){
        Allure.step("Отображается заголовок Панель Управления");
        waitUntilElement("Панель \n управления");
        existText(controlPanelTitle, "Панель \n управления");
    }

}

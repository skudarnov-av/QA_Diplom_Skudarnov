package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class Quotes extends BasePage {

    private static final ViewInteraction titleText = onView(withId(R.id.our_mission_title_text_view));

    public static void thematicBlockOneCheck(){
        Allure.step("Проверка отображения всех полей");
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(not(isDisplayed())));
    }
    public static void descriptionCheck(){
        Allure.step("Проверка отображения поля Описание при тапе");
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).perform(click());
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
    }

    public static void titleCheck(){
        Allure.step("Проверка наличия заголовка");
        titleText.check(matches(isDisplayed()));
    }
    public static void titleTextCheck(){
        Allure.step("Проверка наличия заголовка");
        existText(titleText,"Главное - жить любя");
    }
    public static void swipeUp(){
        Allure.step("Свайп блока вверх");
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 2)).perform(customSwipeUp());
    }
}

package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;


public class HeaderPage extends BasePage {
    private static final ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    private static final ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    private static final ViewInteraction thematicButton = onView(withId(R.id.our_mission_image_button));
    private static final ViewInteraction lkButton = onView(withId(R.id.authorization_image_button));


    public static void mainMenuButtonCheck(){
        Allure.step("Кнопка Главное меню видна и кликабельна");
        waitUntilElement(R.id.main_menu_image_button);
        existClickable(mainMenuButton);
    }

    public static void thematicButtonCheck(){
        Allure.step("Кнопка Цитаты видна и кликабельна");
        existClickable(thematicButton);
    }

    public static void lkButtonCheck(){
        Allure.step("Кнопка Личный кабинет видна и кликабельна");
        existClickable(lkButton);
    }

    public static void logoCheck(){
        Allure.step("Лого присутствует и не кликабелен");
        waitUntilElement(R.id.trademark_image_view);
        existNotClickable(logoView);
    }


    public static void mainMenuButtonClick(){
        Allure.step("Тап по кнопке Главное меню");
        waitUntilElement(R.id.main_menu_image_button);
        mainMenuButton.perform(click());
    }

    public static void thematicButtonClick(){
        Allure.step("Тап по кнопке Цитаты");
        waitUntilElement(R.id.our_mission_image_button);
        thematicButton.perform(click());
    }

    public static void lkButtonClick(){
        Allure.step("Тап по кнопке ЛК");
        waitUntilElement(R.id.authorization_image_button);
        lkButton.perform(click());
    }
}

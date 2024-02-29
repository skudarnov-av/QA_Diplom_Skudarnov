package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class MainMenu extends BasePage {

    private static final String mainPageTextRu = "Главная";
    private static final String claimPageTextRu = "Заявки";
    private static final String NewsPageTextRu = "Новости";
    private static final String aboutPageTextRu = "О приложении";
    private static final ViewInteraction mainPageButton = onView(withText("Главная")).inRoot(isPopupWindow());
    private static final ViewInteraction claimPageButton = onView(withText("Заявки")).inRoot(isPopupWindow());
    private static final ViewInteraction newsPageButton = onView(withText("Новости")).inRoot(isPopupWindow());
    private static final ViewInteraction aboutPageButton = onView(withText("О приложении")).inRoot(isPopupWindow());



    public static void mainPageButtonCheck() {
        Allure.step("Кнопка Главная страница видна и кликабельна, текст совпадает");
        existText(mainPageButton, mainPageTextRu);
    }

    public static void claimPageButtonCheck() {
        Allure.step("Кнопка видна и кликабельна, текст совпадает");
        existText(claimPageButton, claimPageTextRu);
    }

    public static void newsPageButtonCheck() {
        Allure.step("Кнопка Новости видна и кликабельна, текст совпадает");
        existText(newsPageButton, NewsPageTextRu);
    }

    public static void aboutPageButtonCheck() {
        Allure.step("Кнопка О приложении видна и кликабельна, текст совпадает");
        existText(aboutPageButton, aboutPageTextRu);
    }

    public static void mainPageButtonNotClickCheck() {
        Allure.step("Кнопка видна и некликабельна, текст совпадает");
        existNotClickableText(mainPageButton, mainPageTextRu);
    }

    public static void claimPageButtonNotClickCheck() {
        Allure.step("Кнопка видна и некликабельна, текст совпадает");
        existNotClickableText(claimPageButton, claimPageTextRu);
    }

    public static void newsPageButtonNotClickCheck() {
        Allure.step("Кнопка видна и некликабельна, текст совпадает");
        existNotClickableText(newsPageButton, NewsPageTextRu);
    }

    public static void mainPageButtonClick() {
        Allure.step("Тап по кнопке");
        mainPageButton.perform(click());
        pauseShort();
    }

    public static void claimPageButtonClick() {
        Allure.step("Тап по кнопке");
        claimPageButton.perform(click());
        pauseShort();
    }

    public static void newsPageButtonClick() {
        Allure.step("Тап по кнопке");
        newsPageButton.perform(click());
        pauseShort();
    }

    public static void aboutPageButtonClick() {
        Allure.step("Тап по кнопке");
        aboutPageButton.perform(click());
        pauseShort();
    }

    public static void menuConsist() {
        Allure.step("Проверка содержимого меню");
        mainPageButton.check(matches(isDisplayed()));
        mainPageButton.check(matches(withText(MainMenu.mainPageTextRu)));
        newsPageButton.check(matches(isDisplayed()));
        newsPageButton.check(matches(withText(MainMenu.NewsPageTextRu)));
        aboutPageButton.check(matches(isDisplayed()));
        aboutPageButton.check(matches(withText(MainMenu.aboutPageTextRu)));
        claimPageButton.check(matches(isDisplayed()));
        claimPageButton.check(matches(withText(MainMenu.claimPageTextRu)));
    }
}
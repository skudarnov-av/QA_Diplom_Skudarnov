package ru.iteco.fmhandroid.ui.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AboutApp;
import ru.iteco.fmhandroid.ui.steps.Claim;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.MainPage;
import ru.iteco.fmhandroid.ui.steps.News;
import ru.iteco.fmhandroid.ui.steps.Quotes;

public class QuotesTest extends BeforeRunTest {
    @Before
    public void openPage(){
        HeaderPage.thematicButtonClick();
    }

    @Description("проверка работы выпадающего меню на странице Тематические Цитаты")
    @Story("Проверка Страницы Тематические Цитаты")
    @Test
    public void shouldHaveRequiredElements(){
        HeaderPage.mainMenuButtonClick();
        clickBack();
        Quotes.titleTextCheck();
        menuContainCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.mainPageButtonClick();
        MainPage.newsHeaderTitleCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        News.titleNewsHeaderCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        Claim.titleClaimHeaderCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();
        MainMenu.aboutPageButtonClick();
        AboutApp.versionTitleIdCheck();
        clickBack();

        headerCheck();

        Quotes.thematicBlockOneCheck();
        Quotes.titleTextCheck();
    }

    @Description("Проверка заголовка на странице Тематические цитаты")
    @Story("Проверка Страницы Тематические Цитаты")
    @Test
    public void shouldHaveHeaderAndHeaderShouldBeWhenSwipeUp(){
        headerCheck();
        Quotes.swipeUp();
        headerCheck();
        Quotes.titleCheck();
    }

    @Description("Работа кнопки развернуть на странице Тематические цитаты")
    @Story("Проверка Страницы Тематические Цитаты")
    @Test
    public void shouldShowDescriptionWhenTapOnCard(){
        Quotes.descriptionCheck();
    }
}

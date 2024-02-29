package ru.iteco.fmhandroid.ui.test;

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

public class MainMenuTest extends BeforeRunTest {

    @Description("Проверка раскрывающегося меню навигация")
    @Story("Проверка Раскрывающегося Меню")
    @Test
    public void menuShouldHaveRequiredElements() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.mainPageButtonCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.mainPageButtonNotClickCheck();

        MainMenu.newsPageButtonCheck();
        MainMenu.aboutPageButtonCheck();
        MainMenu.claimPageButtonCheck();
        clickBack();
    }

    @Description("Проверка и переход между страницами из главного меню")
    @Story("Проверка Раскрывающегося Меню")
    @Test
    public void shouldOpenCascadePageA() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        News.titleNewsHeaderCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonNotClickCheck();
        clickBack();
        clickBack();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        Claim.titleClaimHeaderCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonNotClickCheck();
        clickBack();
        clickBack();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.aboutPageButtonClick();
        AboutApp.versionTitleIdCheck();

        clickBack();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenu.mainPageButtonClick();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        News.titleNewsHeaderCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenu.aboutPageButtonClick();
        AboutApp.versionTitleIdCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenu.mainPageButtonClick();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        Claim.titleClaimHeaderCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenu.aboutPageButtonClick();
        AboutApp.versionTitleIdCheck();
        clickBack();
    }
}

package ru.iteco.fmhandroid.ui.test;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AboutApp;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.MainMenu;

public class AboutAppTest extends BeforeRunTest {

    @Description("На странице О приложении видны все элементы")
    @Story("Проверка Страницы о Приложении")

    @Test
    public void shouldHaveRequiredUIElements() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.aboutPageButtonClick();
        AboutApp.versionTitleIdCheck();
        AboutApp.backButtonCheck();
        AboutApp.logoCheck();
        AboutApp.versionTextIdCheck();
        AboutApp.policyTextIdCheck();
        AboutApp.policyLinkIdCheck();
        AboutApp.userAgreementTextIdCheck();
        AboutApp.userAgreementLinkIdCheck();
        AboutApp.companyIdCheck();
        AboutApp.backButtonClick();
    }
}

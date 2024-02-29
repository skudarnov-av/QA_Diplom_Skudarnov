package ru.iteco.fmhandroid.ui.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BasePage;
import ru.iteco.fmhandroid.ui.steps.SplashScreenPage;

@RunWith(AllureAndroidJUnit4.class)
public class SplashScreenTest extends BasePage {
    @Description("На Стартовой странице представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
    @Test
    public void shouldHaveRequiredUIElements(){
        SplashScreenPage.screenSplashCheK();
    }
}

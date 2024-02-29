package ru.iteco.fmhandroid.ui.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.Login;
import ru.iteco.fmhandroid.ui.data.BasePage;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.LkMenu;
import ru.iteco.fmhandroid.ui.steps.SplashScreenPage;

@RunWith(AllureAndroidJUnit4.class)
public class LoginTest extends BasePage {
    private static Login login = new Login();
    private static LkMenu lkMenu = new LkMenu();
    private static HeaderPage headerPage = new HeaderPage();

    @Before
    public void logoutCheck() {
        try {
            login.titleTextElementCheck();
        } catch (Exception e) {
            headerPage.lkButtonClick();
            lkMenu.logoutButtonClick();
            login.titleTextElementCheck();
        }
    }

//    @Rule
//    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
//            new ActivityScenarioRule<>(AppActivity.class);
//
//    public void login() {
//        Login.loginFieldAsTextFieldType("login2");
//        Login.passwordFieldAsTextFieldType("password2");
//        Login.loginButtonClick();
//    }
//
//    public void logout() {
//        HeaderPage.lkButtonClick();
//        LkMenu.logoutButtonClick();
//    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
    @Test
    public void ShouldBeVisibleAllElementsLogin() {
        Login.fieldsCheck();
    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка страницы Авторизации")
    @Test
    public void ShouldShowElementsAuthPage() {
        Login.loginButtonClick();
        Login.loginFieldAsTextFieldClick();
        assertTrue(isKeyboardOpenedShellCheck());
        Login.passwordFieldAsTextFieldClick();
        assertTrue(isKeyboardOpenedShellCheck());
        clickBack();
        waitUntilKeyboardHide();
        assertFalse(isKeyboardOpenedShellCheck());
    }

    @Description("При пустом поле появляется сообщение об ошибке")
    @Story("Проверка страницы Авторизации")
    @Test
    public void shouldShowErrorWithOneEmptyField() {
        Login.loginFieldAsTextFieldType("login");
        Login.loginButtonClick();
        Login.errorEmptyFieldsCheck();

        Login.loginFieldAsTextFieldClear();
        Login.passwordFieldAsTextFieldType("password");
        Login.loginButtonClick();
        Login.errorEmptyFieldsCheck();
        Login.passwordFieldAsTextFieldClear();
    }

    @Description("При вводе произвольных логин пароль не входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Test
    public void shouldShowErrorWithWrongValues() {
        Login.loginFieldAsTextFieldType("login");
        Login.passwordFieldAsTextFieldType("password");
        Login.loginButtonClick();
        Login.errorWrongLoginOrPassword();
    }

    @Description("При вводе валидных логин пароль входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Test
    public void ShouldLogin() {
        Login.titleTextElementCheck();
        Login.loginFieldAsTextFieldType("login2");
        Login.passwordFieldAsTextFieldType("password2");
        waitUntilKeyboardHide();
        Login.loginButtonClick();
    }
    @Description("При вводе валидных логин пароль входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Test
    public void ShouldLoginWithValidData() {
        Login.titleTextElementCheck();
        Login.loginWithValidData(authInfo());
        Login.loginButtonClick();
    }


}

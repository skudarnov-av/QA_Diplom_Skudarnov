package ru.iteco.fmhandroid.ui.data;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.LkMenu;
import ru.iteco.fmhandroid.ui.steps.Login;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class BeforeRunTest extends BasePage {
    @Before
    public void login() {
        try {
            Login.loginFieldAsTextFieldType("login2");
            Login.passwordFieldAsTextFieldType("password2");
            Login.loginButtonClick();
        } catch (PerformException | NoMatchingViewException e) {
            System.out.println("Already login");
        } finally {
            MainPage.waitLoadMainPage();
        }
    }

    @After
    public void logout() {
        try {
            HeaderPage.lkButtonClick();
            LkMenu.logoutButtonClick();
        } catch (androidx.test.espresso.PerformException e) {
            System.out.println("Something went wrong: ");
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            System.out.println("I need more time...");
        }

    }

    public static void headerCheck() {
        HeaderPage.mainMenuButtonCheck();
        HeaderPage.logoCheck();
        HeaderPage.thematicButtonCheck();
        HeaderPage.lkButtonCheck();
    }

    public static void menuContainCheck() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.menuConsist();
        clickBack();
    }

}

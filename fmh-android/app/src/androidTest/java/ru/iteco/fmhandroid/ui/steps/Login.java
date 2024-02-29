package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.BasePage;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.R;

public class Login extends BasePage {
    private static final ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    private static final ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    private static final ViewInteraction loginButton = onView(withText("Войти"));
    private static final ViewInteraction loginFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.login_text_input_layout))));
    private static final ViewInteraction passwordFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.password_text_input_layout))));
    private static final ViewInteraction titleTextElement = onView(withText("Авторизация"));


    public static void titleTextElementCheck() {
        Allure.step("Кнопка видна и кликабельна, текст соответстует");
        waitUntilElement(R.id.login_text_input_layout);
        existNotClickableText(titleTextElement, "Авторизация");
    }


    public static void loginFieldAsTextFieldClick() {
        Allure.step("Тап по полю Логин");
        loginFieldAsTextField.perform(click());
    }


    public static void passwordFieldAsTextFieldClick() {
        Allure.step("Тап по полю Пароль");
        passwordFieldAsTextField.perform(click());
    }


    public static void loginFieldAsTextFieldClear() {
        Allure.step("Очистить поле Логин");
        loginFieldAsTextField.perform(clearText());
        pauseSSt();
    }


    public static void passwordFieldAsTextFieldClear() {
        Allure.step("Очистить поле Пароль");
        passwordFieldAsTextField.perform(clearText());
        pauseSSt();
    }


    public static void loginButtonClick() {
        Allure.step("Тап по кнопке Авторизация");
        waitUntilElement("Войти");
        loginButton.perform(click());
    }

    public static void loginWithValidData(BasePage.AuthInfo info) {
        Allure.step("Авторизация с валидными данными");
        waitUntilElement(R.id.login_text_input_layout);
        loginFieldAsTextField.perform(replaceText(info.getLogin()));
        passwordFieldAsTextField.perform(replaceText(info.getPass()));
    }


    public static void loginFieldAsTextFieldType(String text) {
        Allure.step("Ввести текст в поле Логин");
        waitUntilElement(R.id.login_text_input_layout);
        typeT(loginFieldAsTextField, text);
    }


    public static void passwordFieldAsTextFieldType(String text) {
        Allure.step("Ввести текст в поле Пароль");
        waitUntilElement(R.id.password_text_input_layout);
        typeT(passwordFieldAsTextField, text);
        passwordFieldAsTextField.perform(closeSoftKeyboard());
    }


    public static void fieldsCheck() {
        Allure.step("На странице Авторизации представлены необходимые элементы");
        waitUntilElement("Авторизация");
        Login.titleTextElement.check(matches(isDisplayed()));
        Login.titleTextElement.check(matches(withText("Авторизация")));

        Login.loginField.check(matches(isDisplayed()));
        Login.passwordField.check(matches(isDisplayed()));
        Login.loginButton.check(matches(isDisplayed()));

        Login.loginField.check(matches(hasTextInputLayout("Логин")));
        Login.passwordField.check(matches(hasTextInputLayout("Пароль")));
        Login.loginButton.check(matches((withText("Войти"))));
    }


    public static void errorEmptyFieldsCheck() {
        Allure.step("Проверка ошибки поля не могут быть пустые");
        onView(withText(R.string.empty_login_or_password)).inRoot(new ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
    }


    public static void errorWrongLoginOrPassword() {
        Allure.step("Проверка ошибки поля не могут быть пустые");
        onView(withText(R.string.wrong_login_or_password)).inRoot(new BeforeRunTest.ToastMatcher())
                .check(matches(withText("Неверный логин или пароль")));
    }

}

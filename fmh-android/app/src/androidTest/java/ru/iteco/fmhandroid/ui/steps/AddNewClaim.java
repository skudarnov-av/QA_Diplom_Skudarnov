package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class AddNewClaim extends BasePage {
    private static final ViewInteraction titleHeader = onView(withId(R.id.custom_app_bar_title_text_view));
    private static final ViewInteraction subTitleHeader = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    private static final ViewInteraction titleField = onView(withId(R.id.title_edit_text));
    private static final ViewInteraction textCounter = onView(withId(R.id.textinput_counter));
    private static final ViewInteraction executorField = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    private static final ViewInteraction dateField = onView(withId(R.id.date_in_plan_text_input_edit_text));
    private static final ViewInteraction timeField = onView(withId(R.id.time_in_plan_text_input_edit_text));
    private static final ViewInteraction descriptionField = onView(withId(R.id.description_edit_text));
    private static final ViewInteraction saveButton = onView(withId(R.id.save_button));
    private static final ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    private static final ViewInteraction noSaveChangesMessage = onView(withText("Изменения не будут сохранены. Вы действительно хотите выйти?"));
    private static final ViewInteraction noSaveChangesCancelButton = onView(withText("Отмена"));
    private static final ViewInteraction noSaveChangesOkButton = onView(withText("OK"));
    private static final ViewInteraction calendarOkButton = onView(withId(android.R.id.button1));
    private static final ViewInteraction timeOKButton = onView(withId(android.R.id.button1));
    private static final ViewInteraction emptyFieldMessage = onView(withText("Заполните пустые поля"));
    private static final ViewInteraction emptyFieldOkButton = onView(withId(android.R.id.button1));


    public static void titleHeaderCheck() {
        Allure.step("Проверка наличия заголовка Создание страницы");
        waitUntilElement(R.id.custom_app_bar_title_text_view);
        titleHeader.check(matches(isDisplayed()));
    }

    public static void cancelButtonClick() {
        Allure.step("Кликнуть по кнопке Отмена создания заявки");
        waitUntilElement(R.id.cancel_button);
        cancelButton.perform(click());
    }

    public static void noSaveChangesCancelButtonClick() {
        Allure.step("Кликнуть по кнопке Отмена окна сообщения");
        waitUntilElement("Отмена");
        noSaveChangesCancelButton.perform(click());
    }

    public static void calendarOkButtonClick() {
        Allure.step("Кликнуть по кнопке OK");
        calendarOkButton.perform(click());
    }

    public static void timeFieldClick() {
        Allure.step("Кликнуть по кнопке OK");
        timeField.perform(click());
    }

    public static void timeOKButtonClick() {
        Allure.step("Кликнуть по кнопке");
        timeOKButton.perform(click());
    }

    public static void dateFieldClick() {
        Allure.step("Кликнуть по кнопке OK");
        dateField.perform(click());
    }

    public static void saveButtonClick() {
        Allure.step("Кликнуть по кнопке Сохранить");
        saveButton.perform(click());
    }

    public static void emptyFieldOkButtonClick() {
        Allure.step("Кликнуть по кнопке Сохранить");
        emptyFieldOkButton.perform(click());
    }

    public static void noSaveChangesOkButtonClick() {
        Allure.step("Кликнуть по кнопке OK окна сообщения");
        noSaveChangesOkButton.perform(click());
    }

    public static void descriptionFieldHide() {
        Allure.step("Кликнуть по полю и скрыть клавиатуру");
        descriptionField.perform(closeSoftKeyboard());
        waitUntilKeyboardHide();
    }

    public static void titleFieldClickAndHide() {
        Allure.step("Кликнуть по полю и скрыть клавиатуру");
        titleField.perform(click());
        titleField.perform(closeSoftKeyboard());
    }

    public static void titleFieldType(String text) {
        Allure.step("Ввести в поле значение");
        typeT(titleField, text);
    }

    public static void descriptionFieldType(String text) {
        Allure.step("Ввести в поле значение");
        typeT(descriptionField, text);
    }

    public static void elementsCheckAll() {
        Allure.step("Проверка наличия всех элементов на странице");
        titleHeader.check(matches(isDisplayed()));
        subTitleHeader.check(matches(isDisplayed()));
        titleField.check(matches(isDisplayed()));
        textCounter.check(matches(isDisplayed()));
        executorField.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.text_input_end_icon), 1)).check(matches(isDisplayed()));
        dateField.check(matches(isDisplayed()));
        timeField.check(matches(isDisplayed()));
        descriptionField.check(matches(isDisplayed()));
        saveButton.check(matches(isDisplayed()));
        cancelButton.check(matches(isDisplayed()));
        saveButton.check(matches(isClickable()));
        cancelButton.check(matches(isClickable()));
        saveButton.check(matches(withText("Сохранить")));
        cancelButton.check(matches(withText("Отмена")));
        titleHeader.check(matches(withText("Создание")));
        subTitleHeader.check(matches(withText("Заявки")));
        titleField.check(matches(withHint("Тема")));
        executorField.check(matches(withHint("Исполнитель")));
        dateField.check(matches(withHint("Дата")));
        timeField.check(matches(withHint("Время")));
        descriptionField.check(matches(withHint("Описание")));
    }

    public static void emptyFieldMessageCheck() {
        Allure.step("Проверка сообщения об ошибке в виде всплывающего окна");
        waitUntilElement("Заполните пустые поля");
        emptyFieldMessage.check(matches(isDisplayed()));
        emptyFieldOkButton.check(matches(isDisplayed()));
        emptyFieldMessage.check(matches(withText("Заполните пустые поля")));
        emptyFieldOkButton.check(matches(withText("OK")));
        emptyFieldOkButton.check(matches(isClickable()));
    }

    public static void noChangesMessageCheck() {
        Allure.step("Проверка сообщения о несохраненных изменениях на странице");
        waitUntilElement("Изменения не будут сохранены. Вы действительно хотите выйти?");
        noSaveChangesMessage.check(matches(isDisplayed()));
        noSaveChangesMessage.check(matches(withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        noSaveChangesCancelButton.check(matches(isDisplayed()));
        noSaveChangesCancelButton.check(matches(withText("Отмена")));
        noSaveChangesCancelButton.check(matches(isClickable()));

        noSaveChangesOkButton.check(matches(isDisplayed()));
        noSaveChangesOkButton.check(matches(withText("OK")));
        noSaveChangesOkButton.check(matches(isClickable()));
    }

}

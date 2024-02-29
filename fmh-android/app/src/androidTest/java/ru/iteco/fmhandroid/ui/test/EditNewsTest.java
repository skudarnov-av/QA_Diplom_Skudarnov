package ru.iteco.fmhandroid.ui.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewNews;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.NewsControl;
import ru.iteco.fmhandroid.ui.steps.News;

public class EditNewsTest extends BeforeRunTest {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        News.controlPanelButtonClick();
        NewsControl.editButtonClick();
    }

    @Description("Страница содержит заголовок Редактирование Новости")
    @Story("Проверка Страницы Редактирование Новости")
    @Test
    public void shouldHaveRequiredElements() {
        AddNewNews.titleCheck("Редактирование");
        AddNewNews.switcherCheck();
        AddNewNews.fieldsCheck();
        clickBack();
    }

    @Description("Раскрывающийся список Категория содержит перечень категорий")
    @Story("Проверка Страницы Редактирование Новости")
    @Test
    public void shouldHaveAllCategoriesInDropMenu() {
        AddNewNews.categoryFieldClick();
        AddNewNews.categoryFieldClear();
        AddNewNews.categoryFieldClick();
        AddNewNews.categoryFieldHide();
        waitUntilKeyboardHide();
        AddNewNews.categoryDropListCheck();
        clickBack();
        AddNewNews.cancelButtonClick();
        AddNewNews.noSaveChangesOkButtonClick();
    }


    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Редактирование Новости")
    @Test
    public void shouldOpenCalendarWhenTapDateField() { //!
        AddNewNews.dateFieldClick();
        AddNewNews.calendarBaseCheck();
        clickBack();
        AddNewNews.newsAddEditPageLoadWaits();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Редактирование Новости")
    @Test
    public void shouldOpenClockWhenTapTimeField() {
        AddNewNews.timeFieldClick();
        AddNewNews.clockBaseCheck();
        clickBack();
        AddNewNews.newsAddEditPageLoadWaits();
        clickBack();
    }

    @Description("При сохранении Новости c незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Редактирование Новости")
    @Test
    public void shouldShowErrorWithEmptyFields() {
        AddNewNews.descriptionFieldClick();
        AddNewNews.descriptionFieldClear();
        AddNewNews.descriptionFieldHide();
        AddNewNews.saveButtonClick();
        AddNewNews.errorFillEmptyFieldsCheck();
    }
}

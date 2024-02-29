package ru.iteco.fmhandroid.ui.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewNews;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.LkMenu;
import ru.iteco.fmhandroid.ui.steps.Login;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.News;


public class AddNewNewsTest extends BeforeRunTest {

    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        News.titleNewsHeaderCheck();
        News.controlPanelButtonClick();
        News.addNewNewsButtonCheck();
        News.addNewNewsButtonClick();

    }

    @Description("Создание новой новости с валидными данными")
    @Story("Проверка Страницы Создание Новости")
    @Test
    public void shouldBeAddedNewNews() {
        AddNewNews.categoryFieldClick();
        AddNewNews.setCategoryFieldClick();
        AddNewNews.dateFieldClick();
        AddNewNews.timeOKButtonClick();
        AddNewNews.timeFieldClick();
        AddNewNews.timeOKButtonClick();
        AddNewNews.descriptionFieldClick();
        AddNewNews.descriptionFieldType("This my clever news");
        AddNewNews.descriptionFieldHide();
        AddNewNews.saveButtonClick();
        News.shouldBeVisibleDescriptionText();
        clickBack();
    }

    @Description("Страница содержит заголовок Создание Новости")
    @Story("Проверка Страницы Создание Новости")
    @Test
    public void shouldHaveRequiredElements() {
        AddNewNews.titleCheck("Создание");
        AddNewNews.switcherCheck();
        AddNewNews.fieldsCheck();
        AddNewNews.placeholdersCheck();
        clickBack();
    }

    @Description("Раскрывающийся список Категория содержит перечень категорий")
    @Story("Проверка Страницы Создание Новости")
    @Test
    public void shouldHaveAllCategoriesInDropMenu() {
        AddNewNews.openDropList();
        AddNewNews.categoryDropListCheck();
        clickBack();
        AddNewNews.cancelButtonClick();
        AddNewNews.noSaveChangesOkButtonClick();
    }


    @Description("При клике по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Создание Новости")
    @Test
    public void shouldOpenCalendarWhenTapDateField() {
        AddNewNews.dateFieldClick();
        AddNewNews.calendarBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Создание Новости")
    @Test
    public void shouldOpenClockWhenTapTimeField() {
        AddNewNews.timeFieldClick();
        AddNewNews.clockBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Создание Новости")
    @Test
    public void shouldShowErrorWithEmptyFields() {
        AddNewNews.saveButtonClick();
        AddNewNews.errorFillEmptyFieldsCheck();
    }
}

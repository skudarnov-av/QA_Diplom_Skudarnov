package ru.iteco.fmhandroid.ui.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewNews;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.NewsCard;
import ru.iteco.fmhandroid.ui.steps.NewsControl;
import ru.iteco.fmhandroid.ui.steps.News;

public class NewsControlTest extends BeforeRunTest {
    @Before
    public void openControlPage(){
        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
        News.controlPanelButtonClick();
    }

    @Description("На странице Панель управления есть все элементы")
    @Story("Проверка Страницы Панель Управления")
    @Test
    public void shouldDisplayNewsFieldsForControlPanel(){
        News.addNewNewsButtonCheck();
        NewsCard.newsCardFullCheck();
        NewsCard.editButtonCheck();
        NewsCard.deleteButtonCheck();
        NewsCard.statusButtonCheck();
        NewsControl.controlPanelTitleCheck();
    }

    @Description("При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Story("Проверка Страницы Панель Управления")
    @Test
    public void shouldOpenFilterPage(){
        News.filterButtonClick();
        News.filterBaseCheck();
        NewsControl.filterActiveSwitchCheck();
        NewsControl.filterInactiveSwitchCheck();
        NewsControl.filterActiveChecked();
        NewsControl.filterInactiveSwitchChecked();
        clickBack();
    }

    @Description("При тапе по селектору Категория раскрывается выпадающий список с категориями")
    @Story("Проверка Страницы Панель Управления")
    @Test
    public void shouldHaveCategories(){
        News.filterButtonClick();
        News.filterCategoryClick();
        AddNewNews.categoryDropListCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Панель Управления")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        News.filterButtonClick();
        News.filterDateStartClick();
        AddNewNews.calendarBaseCheck();
        AddNewNews.timeOKButtonClick();
        News.filterDateEndClick();
        AddNewNews.calendarBaseCheck();
        AddNewNews.timeOKButtonClick();
        clickBack();
    }

    @Description("При тапе по кнопке Добавить (+) открывается старница Создание новости")
    @Story("Проверка Страницы Панель Управления")
    @Test
    public void shouldOpenAddNewNewsPAgeWhenTapOnButton(){
        News.addNewNewsButtonClick();
        AddNewNews.titleCheck("Создание");
        clickBack();
    }
}

package ru.iteco.fmhandroid.ui.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewNews;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.NewsControl;
import ru.iteco.fmhandroid.ui.steps.News;

public class NewsTest extends BeforeRunTest {
    @Before
    @DisplayName("Открыть страницу новости")
    public void openNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.newsPageButtonClick();
    }

    @Description("Страница Новости содержит поля ...")
    @Story("Проверка Страницы Новости")
    @Test
    public void shouldHaveRequiredElements(){
        News.titleNewsHeaderCheck();
        News.filterButtonCheck();
        News.sorterButtonCheck();
        News.controlPanelButtonCheck();
        News.newsCardStdCheck();
    }

    @Description("При тапе по кнопке раскрыть новость, отображается описание новости")
    @Story("Проверка Страницы Новости")
    @Test
    public void shouldShowDescriptionWhenTapOnNews(){
        News.newsCardDescriptionsCheck();
    }

    @Description("При скролле вверх новости прокручиваются, хедер закреплен")
    @Story("Проверка Страницы Новости")
    @Test
    public void shouldHaveHeader(){
        headerCheck();
        News.swipeUpNewsBlock();
        headerCheck();
    }

    @Description("При тапе по кнопке Редактировать открывается окно редактирования новости")
    @Story("Проверка Страницы Новости")
    @Test
    public void shouldSwitchToControlPanelAndBack(){
        News.controlPanelButtonCheck();
        News.controlPanelButtonClick();
        NewsControl.editButtonClick();
        AddNewNews.titleCheck("Редактирование");
    }

    @Description("При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Story("Проверка Страницы Новости")
    @Test
    public void shouldOpenFilterPage(){
        News.filterButtonClick();
        News.filterBaseCheck();
        clickBack();
    }

    @Description("При тапе по селектору Категория раскрывается выпадающий список с категориями")
    @Story("Проверка Страницы Новости")
    @Test
    public void shouldHaveCategories(){
        News.filterButtonClick();
        News.filterCategoryClick();
        AddNewNews.categoryDropListCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Новости")
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
}

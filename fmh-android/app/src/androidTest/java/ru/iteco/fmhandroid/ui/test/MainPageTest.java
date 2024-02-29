package ru.iteco.fmhandroid.ui.test;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewClaim;
import ru.iteco.fmhandroid.ui.steps.Claim;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.LkMenu;
import ru.iteco.fmhandroid.ui.steps.MainPage;
import ru.iteco.fmhandroid.ui.steps.NewsCard;
import ru.iteco.fmhandroid.ui.steps.News;

public class MainPageTest extends BeforeRunTest {
    @Description("На Главной странице  отображается Раздел Новости")
    @Story("Проверка Главной страницы")
    @Test
    public void headerHasRequiredElements() {
        headerCheck();
        MainPage.claimBlockHeaderSwipe();
        MainPage.claimShowAllButtonSwipe();
        HeaderPage.logoCheck();
        HeaderPage.lkButtonClick();
        LkMenu.logoutButtonCheck();
        clickBack();
    }

    @Description("На Главной странице отображаются заголовки")
    @Story("Проверка Главной страницы")
    @Test
    public void shouldHaveRequiredElements(){
        MainPage.containerNewsHeaderCheck();
        MainPage.newsContainerOneClickableCheck();
        MainPage.newsHeaderTitleCheck();

        MainPage.newsAllNewsButtonCheck();

        MainPage.countNewsIs(3);

        MainPage.newsHeaderTitleCheck();
        MainPage.newsCollapseButtonCheck();

        MainPage.newsContainerOneIsHidden();
        MainPage.newsAllNewsButtonNotCheck();
        MainPage.newsContainerClick();

        NewsCard.newsCardFullShortCheck();

        MainPage.claimBlockHeaderCheck();
        MainPage.claimBlockHeaderSwipe();
        MainPage.claimAddNewButtonCheck();
        MainPage.claimExpandButtonCheck();
        MainPage.newsOneClickable();
        MainPage.claimShowAllButtonCheck();
    }

    @Description("На Главной странице отображается описание")
    @Story("Проверка Главной страницы")
    @Test
    public void shouldShowDescriptionFieldWhenTapNews(){
        MainPage.containerNewsHeaderClick();
    }

    @Description("При тапе по кнопке ВСЕ НОВОСТИ открывается страница новостей")
    @Story("Проверка Главной страницы")
    @Test
    public void shouldOpenPageNewsWhenTapOnButtonAllNews(){
        MainPage.newsAllNewsButtonClick();
        News.titleNewsHeaderCheck();
        clickBack();
        MainPage.claimBlockHeaderCheck();
    }

    @Description("При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Story("Проверка Главной страницы")
    @Test
    public void shouldOpenPageClaimsWhenTapOnButtonAllClaims() {
        MainPage.claimShowAllButtonClick();
        Claim.titleClaimHeaderCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();

    }
    @Description("При тапе по кнопке + (добавить заявку) открывается страница Создание заявки")
    @Story("Проверка Главной страницы")
    @Test
    public void shouldOpenAddNewClaimPageWhenTapAddClaimButton(){
        MainPage.claimAddNewButtonClick();
        AddNewClaim.titleHeaderCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();
    }

    @Description("При прокрутке Главного экрана Хедер не прокручивается")
    @Story("Проверка Главной страницы")
    @Test
    public void shouldShowHeaderWhenSwipeUp(){
        MainPage.claimShowAllButtonSwipe();
        HeaderPage.logoCheck();
    }
}

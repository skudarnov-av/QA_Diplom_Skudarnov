package ru.iteco.fmhandroid.ui.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewClaim;
import ru.iteco.fmhandroid.ui.steps.ClaimCard;
import ru.iteco.fmhandroid.ui.steps.Claim;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.MainMenu;

public class ClaimTest extends BeforeRunTest {
    @Before
    public void openClaimPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
    }

    @Description("Проверка страницы Заявки")
    @Story("Проверка страницы Заявки")
    @Test
    public void shouldHaveRequiredElements(){
        Claim.titleClaimHeaderCheck();
        Claim.filterButtonCheck();
        Claim.addNewClaimButtonCheck();
        ClaimCard.cardShortCheck();
    }

    @Description("Открывает карточку заявки при тапе по заявке")
    @Story("Проверка страницы Заявки")
    @Test
    public void shouldOpenClaimCardWhenTapClaim(){
        Claim.claimTap();
        ClaimCard.claimThemeTitleFullCheck();
    }

    @Description("Открыть заявку без комментария")
    @Story("Страница информации о заявке")
    @Test
    public void cardClaimShouldHaveRequiredFields(){
        Claim.openCardWithoutComment();
    }

    @Description("При тапе по кнопке фильтра открывается попап меню Фильтрация")
    @Story("Проверка страницы Заявки")
    @Test
    public void shouldOpenPopupFilter(){
        Claim.filterButtonClick();
        Claim.filterViewCheck();
        Claim.filterTitleCheck();
        Claim.filterCheck();
        clickBack();
    }

    @Description("На странице Заявки отображается хедер")
    @Story("Проверка страницы Заявки")
    @Test
    public void shouldHaveHeader(){
        headerCheck();
        Claim.claimsSwipeUp();
        headerCheck();
    }

    @Description("При тапе по кнопке + (добавить заявку) открывается страница Создание заявки")
    @Story("Проверка страницы Заявки")
    @Test
    public void shouldOpenAddNewClaimPage(){
        Claim.addNewClaimButtonClick();
        AddNewClaim.titleHeaderCheck();
        clickBack();
        Claim.titleClaimHeaderCheck();
    }
}

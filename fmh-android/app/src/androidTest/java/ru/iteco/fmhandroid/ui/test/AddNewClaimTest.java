package ru.iteco.fmhandroid.ui.test;


import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;
import ru.iteco.fmhandroid.ui.steps.AddNewClaim;
import ru.iteco.fmhandroid.ui.steps.AddNewNews;
import ru.iteco.fmhandroid.ui.steps.Claim;
import ru.iteco.fmhandroid.ui.steps.ClaimCard;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.LkMenu;
import ru.iteco.fmhandroid.ui.steps.Login;
import ru.iteco.fmhandroid.ui.steps.MainMenu;
import ru.iteco.fmhandroid.ui.steps.MainPage;

public class AddNewClaimTest extends BeforeRunTest {

    @Before
    public void openNewClaimPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenu.claimPageButtonClick();
        Claim.titleClaimHeaderCheck();
        MainPage.claimAddNewButtonClick();
        AddNewClaim.titleHeaderCheck();

    }

    @Description("На странице присутствуют все элементы")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldHaveRequiredElements() {
        AddNewClaim.elementsCheckAll();
        clickBack();
    }

    @Description("Создание заявки с валидными данными")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldBeCreatedANewRequest() {
        AddNewClaim.titleFieldClickAndHide();
        AddNewClaim.titleFieldType("New My Claim");
        AddNewClaim.dateFieldClick();
        AddNewClaim.calendarOkButtonClick();
        AddNewClaim.timeFieldClick();
        AddNewClaim.timeOKButtonClick();
        AddNewClaim.descriptionFieldType("Test Claim");
        AddNewClaim.descriptionFieldHide();
        AddNewClaim.saveButtonClick();
        Claim.titleClaimHeaderCheck();
    }

    @Description("Появляется модальное окно с информацией о несохраненных действиях и кнопками Отмена и ОК")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldShowPopupWhenTapCancelButton() {
        AddNewClaim.titleFieldClickAndHide();
        AddNewClaim.cancelButtonClick();
        AddNewClaim.noChangesMessageCheck();
        AddNewClaim.noSaveChangesCancelButtonClick();
        AddNewClaim.titleHeaderCheck();
        clickBack();
    }

    @Description("При клике по кнопке OK на модальном окне отмены заявки, модальное окно закрывается")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldOpenMainPageIfTapOkButtonOnPopup() {
        AddNewClaim.cancelButtonClick();
        AddNewClaim.noChangesMessageCheck();
        AddNewClaim.noSaveChangesCancelButtonClick();
    }

    @Description("При сохранении Заявки с незаполненным полем появляется сообщение Заполните пустые поля")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldShowErrorWithEmptyFields() {
        AddNewClaim.saveButtonClick();
        AddNewClaim.emptyFieldMessageCheck();
        AddNewClaim.emptyFieldOkButtonClick();
        clickBack();
    }

    @Description("При клике по полю Дата открывается календарь")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldOpenCalendarWhenTapDateField() {
        AddNewClaim.dateFieldClick();
        AddNewNews.calendarBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("При клике по полю Время открывается окно с выбором времени")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldOpenClockWhenTapTimeField() {
        AddNewClaim.timeFieldClick();
        AddNewNews.clockBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("Нельзя создать заявку с пустым или заполненным пробелами полем Описание")
    @Story("Проверка Страницы Создание заявки")
    @Test
    public void shouldShowErrorWithSpacesInCommentFields() {
        AddNewClaim.titleFieldType("My New error Claim");
        AddNewClaim.dateFieldClick();
        AddNewClaim.calendarOkButtonClick();
        AddNewClaim.timeFieldClick();
        AddNewClaim.timeOKButtonClick();
        AddNewClaim.descriptionFieldType("     ");
        AddNewClaim.descriptionFieldHide();
        AddNewClaim.saveButtonClick();
        AddNewClaim.emptyFieldMessageCheck();
        AddNewClaim.emptyFieldOkButtonClick();
        AddNewClaim.descriptionFieldHide();
        clickBack();
    }

}

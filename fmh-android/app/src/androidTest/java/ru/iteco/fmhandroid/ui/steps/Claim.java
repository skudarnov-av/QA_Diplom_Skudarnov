package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class Claim extends BasePage {
    private static final ViewInteraction titleClaimHeader = onView(withText("Заявки"));
    private static final ViewInteraction filterButton = onView(withId(R.id.filters_material_button));
    private static final ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));

    //popup filter
    private static final ViewInteraction filterView = onView(withId(R.id.customPanel));
    private static final ViewInteraction filterTitle = onView(withId(R.id.claim_filter_dialog_title));
    private static final ViewInteraction statusOpen = onView(withId(R.id.item_filter_open));
    private static final ViewInteraction statusInProgress = onView(withId(R.id.item_filter_in_progress));
    private static final ViewInteraction statusExecuted = onView(withId(R.id.item_filter_executed));
    private static final ViewInteraction statusCancelled = onView(withId(R.id.item_filter_cancelled));
    private static final ViewInteraction filterOkButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    private static final ViewInteraction filterCancelButton = onView(withId(R.id.claim_filter_cancel_material_button));


    public static void titleClaimHeaderCheck(){
        Allure.step("Проверка заголовка Заявки");
        waitUntilElement("Заявки");
        existText(titleClaimHeader,"Заявки");
    }

    public static void filterButtonClick(){
        Allure.step("Тап по кнопке filter");
        filterButton.perform(click());
    }

    public static void filterButtonCheck(){
        Allure.step("Проверка кнопки filter");
        existClickable(filterButton);
    }

    public static void addNewClaimButtonClick(){
        Allure.step("Тап по кнопке +");
        addNewClaimButton.perform(click());
    }

    public static void addNewClaimButtonCheck(){
        Allure.step("Проверка кнопки +");
        existClickable(addNewClaimButton);
    }

    public static void filterViewCheck(){
        Allure.step("Проверка окна фильтра");
        exist(filterView);
    }

    public static void filterTitleCheck(){
        Allure.step("Проверка текста Заголовка");
        existText(filterTitle,"Фильтрация");
    }

    public static void filterCheck() {
        Allure.step("Проверка элементов в фильтре");
        waitUntilElement(R.id.item_filter_open);
        existClickableText(statusOpen, "Открыта");
        existClickableText(statusInProgress, "В работе");
        existClickableText(statusExecuted, "Выполнена");
        existClickableText(statusCancelled, "Отмененные");
        existClickableText(filterOkButton, "ОК");
        existClickableText(filterCancelButton, "Отмена");
    }

    public static void filterOkButtonClick(){
        Allure.step("Тап по кнопке OK");
        filterOkButton.perform(click());
    }

    public static void editButtonClick(){
        Allure.step("Тап по кнопке Cancel");
        filterCancelButton.perform(click());
    }

    public static void openCardWithoutComment(){
        Allure.step("Открываем заявку без комментариев (в данной реализации наугад 3ю карточку)");
        Claim.filterButton.perform(click());
        onView(withText("Открыта")).perform(click());
        onView(withText("В работе")).perform(click());
        onView(withText("Отмененные")).perform(click());
        onView(withId(R.id.claim_list_filter_ok_material_button)).perform(click());
        waitUntilElement(R.id.claim_list_card);
        onView(withIndex(withId(R.id.claim_list_card), 2)).perform(click());
    }

    public static void claimsSwipeUp(){
        Allure.step("swipe up cards");
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseSSt();
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseSSt();
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseSSt();
    }

    public static void claimTap(){
        Allure.step("Тап по заявке");
        onView(withIndex(withId(R.id.claim_list_card), 0)).perform(click());
    }
}

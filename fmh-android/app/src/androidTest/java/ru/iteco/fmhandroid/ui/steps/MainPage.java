package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class MainPage extends BasePage {
    private static final ViewInteraction containerNewsHeader = onView( //общий блок новостей на главной странице (из 3х элементов) под кнопкой ВСЕ НОВОСТИ
            allOf(withId(R.id.all_news_cards_block_constraint_layout),
                    withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                    isDisplayed()));
    private static final ViewInteraction newsContainerOneClickable = onView(withIndex(withId(R.id.news_item_material_card_view), 0));//контейнер одной новости кликабельный, и 3 экз на главной!!!

    private static final ViewInteraction newsHeaderTitle = onView(withText("Новости"));
    private static final ViewInteraction newsCollapseButton = onView(withIndex(withId(R.id.expand_material_button), 0));
    private static final ViewInteraction newsAllNewsButton = onView(withId(R.id.all_news_text_view));

    private static final ViewInteraction claimBlockHeader = onView(
            allOf(withText("Заявки"),
                    withParent(withParent(withId(R.id.container_list_claim_include_on_fragment_main))),
                    isDisplayed()));
    private static final ViewInteraction claimAddNewButton = onView(withId(R.id.add_new_claim_material_button));
    private static final ViewInteraction claimExpandButton = onView(withIndex(withId(R.id.news_item_material_card_view), 1));
    private static final ViewInteraction claimShowAllButton = onView(withId(R.id.all_claims_text_view));

    public static void countNewsIs(int i) {
        onView(withId(R.id.container_list_news_include_on_fragment_main)).check(matches(allOf(
                isDisplayed(),
                hasChildren(is(i))
        )));
    }

    public static void waitLoadMainPage() {
        Allure.step("Ожидание загрузки страницы");
        waitUntilElement(R.id.news_item_material_card_view);
    }

    public static void newsContainerOneClickableCheck() {
        Allure.step("Проверка отображения блока");
        exist(newsContainerOneClickable);
    }

    public static void containerNewsHeaderCheck() {
        Allure.step("Проверка отображения блока");
        exist(containerNewsHeader);
    }

    public static void containerNewsHeaderClick() {
        Allure.step("Тап по блоку, появляется блок Описание");
        containerNewsHeader.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 1)).check(matches(isDisplayed()));
    }

    public static void claimAddNewButtonCheck() {
        Allure.step("Проверка отображения кнопки");
        exist(claimAddNewButton);
    }

    public static void claimAddNewButtonClick() {
        Allure.step("Тап по кнопке");
        claimAddNewButton.perform(click());
        waitUntilElement("Заявки");
    }

    public static void claimExpandButtonCheck() {
        Allure.step("Проверка отображения кнопки");
        exist(claimExpandButton);
    }

    public static void claimExpandButtonClick() {
        Allure.step("Тап по кнопке");
        claimExpandButton.perform(click());
    }

    public static void claimShowAllButtonCheck() {
        Allure.step("Проверка отображения кнопки");
        exist(claimShowAllButton);
    }

    public static void claimShowAllButtonClick() {
        Allure.step("Тап по кнопке");
        claimShowAllButton.perform(click());
    }

    public static void claimBlockHeaderCheck() {
        Allure.step("Проверка отображения заголовка Заявки");
        waitUntilElement("Заявки");
        existText(claimBlockHeader, "Заявки");
    }

    public static void claimShowAllButtonSwipe() {
        Allure.step("Свайп вверх на объекте");
        claimShowAllButton.perform(customSwipeUp());
    }

    public static void claimBlockHeaderSwipe() {
        Allure.step("Свайп вверх на объекте");
        claimBlockHeader.perform(customSwipeUp());
    }

    public static void newsHeaderTitleCheck() {
        Allure.step("Проверка отображения заголовка Новости");
        waitUntilElement("Новости");
        existText(newsHeaderTitle, "Новости");
    }

    public static void newsCollapseButtonCheck() {
        Allure.step("Проверка отображения кнопки");
        exist(newsCollapseButton);
    }

    public static void newsCollapseButtonClick() {
        Allure.step("Тап по кнопке");
        newsCollapseButton.perform(click());
    }

    public static void newsAllNewsButtonCheck() {
        Allure.step("Проверка отображения кнопки");
        existClickableText(newsAllNewsButton, "ВСЕ НОВОСТИ");
    }

    public static void newsAllNewsButtonNotCheck() {
        Allure.step("Проверка отсутствия отображения кнопки");
        newsAllNewsButton.check(matches(not(isDisplayed())));
    }

    public static void newsAllNewsButtonClick() {
        Allure.step("Тап по кнопке");
        newsAllNewsButton.perform(click());
    }

    public static void newsOneClickable() {
        Allure.step("Проверка карточки новостей");
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isClickable()));
    }

    public static void newsContainerOneIsHidden() {
        Allure.step("Проверка что контейнер свернут");
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(not(isDisplayed())));
    }

    public static void newsContainerClick() {
        Allure.step("Проверка что контейнер разворачивается");
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
    }
}

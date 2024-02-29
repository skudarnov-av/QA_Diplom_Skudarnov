package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;


public class AboutApp extends BasePage {
    private static final String aboutAppText = "Версия:";
    private static final String aboutAppVersion = "1.0.0";
    private static final String policyText = "Политика конфиденциальности:";
    private static final String policyLink = "https://vhospice.org/#/privacy-policy";
    private static final String userAgreementText = "Пользовательское соглашение:";
    private static final String userAgreementLink = "https://vhospice.org/#/terms-of-use";
    private static final String companyInfo = "© Айтеко, 2022";
    private static final ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    private static final ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    private static final ViewInteraction versionTitleId = onView(withId(R.id.about_version_title_text_view));
    private static final ViewInteraction versionTextId = onView(withId(R.id.about_version_value_text_view));
    private static final ViewInteraction policyTextId = onView(withId(R.id.about_privacy_policy_label_text_view));
    private static final ViewInteraction policyLinkId = onView(withId(R.id.about_privacy_policy_value_text_view));
    private static final ViewInteraction userAgreementTextId = onView(withId(R.id.about_terms_of_use_label_text_view));
    private static final ViewInteraction userAgreementLinkId = onView(withId(R.id.about_terms_of_use_value_text_view));
    private static final ViewInteraction companyId = onView(withId(R.id.about_company_info_label_text_view));


    public static void backButtonCheck(){
        Allure.step("Кнопка Назад видна и кликабельна");
        existClickable(backButton);
    }

    public static void backButtonClick(){
        Allure.step("Клик по кнопке");
        backButton.perform(click());
    }

    public static void logoCheck(){
        Allure.step("Логотип присутствует");
        existNotClickable(logoView);
    }

    public static void versionTitleIdCheck(){
        Allure.step("Версия приложения заголовок присутствует");
        waitUntilElement(R.id.about_version_title_text_view);
        existText(versionTitleId, aboutAppText);
    }

    public static void versionTextIdCheck(){
        Allure.step("Присутствует текст версии");
        existText(versionTextId, aboutAppVersion);
    }

    public static void policyLinkIdCheck(){
        Allure.step("Присутствует ссылка Политика конфиденциальности");
        existText(policyLinkId, policyLink);
    }

    public static void policyTextIdCheck(){
        Allure.step("Присутствует текст ссылки Политика конфиденциальности");
        existText(policyTextId, policyText);
    }

    public static void userAgreementTextIdCheck(){
        Allure.step("Присутствует текст ссылки Пользовательское соглашение");
        existText(userAgreementTextId, userAgreementText);
    }

    public static void userAgreementLinkIdCheck(){
        Allure.step("Присутствует ссылка Пользовательское соглашение");
        existText(userAgreementLinkId, userAgreementLink);
    }

    public static void companyIdCheck(){
        Allure.step("Присутствует текст О компании");
        existText(companyId, companyInfo);
    }
}

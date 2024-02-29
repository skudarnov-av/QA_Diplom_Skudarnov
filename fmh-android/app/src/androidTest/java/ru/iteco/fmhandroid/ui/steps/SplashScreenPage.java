package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.BasePage;

public class SplashScreenPage extends BasePage {
    private static final ViewInteraction imageId = onView(withId(R.id.splashscreen_image_view));
    private static final ViewInteraction progressBarId = onView(withId(R.id.splash_screen_circular_progress_indicator));
    private static final ViewInteraction textViewId = onView(withId(R.id.splashscreen_text_view));

    public static void screenSplashCheK(){
        Allure.step("Проверка заставки экрана");
        imageId.check(matches(isDisplayed()));
        progressBarId.check(matches(isDisplayed()));
        textViewId.check(matches(isDisplayed()));
    }
}

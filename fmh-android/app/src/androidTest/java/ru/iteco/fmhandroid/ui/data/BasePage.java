package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.Root;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.uiautomator.UiDevice;

import com.google.android.material.textfield.TextInputLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import io.qameta.allure.android.rules.ScreenshotRule;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.BeforeRunTest;


public class BasePage {
    @Rule
    public ScreenshotRule logcatRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, "failure");
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public static class AuthInfo {
        private final String login;
        private final String password;

        public AuthInfo(String login, String pass) {
            this.login = login;
            this.password = pass;
        }

        public String getLogin() {
            return login;
        }

        public String getPass() {
            return password;
        }
    }

    public static AuthInfo authInfo() {
        String login = "login2";
        String pass = "password2";
        return new AuthInfo(login, pass);
    }

    private static final long waitTimeout = 6500;

    public static void waitUntilElement(final int viewId) {
        onView(isRoot()).perform(waitId(viewId, waitTimeout));
    }

    public static void waitUntilElement(final String text) {
        onView(isRoot()).perform(waitId(text, waitTimeout));
    }

    public static void waitUntilPopup(final String text) {
        onView(isRoot()).inRoot(isPopupWindow()).perform(waitId(text, waitTimeout));
    }

    public static void waitUntilKeyboardHide() {
        while (isKeyboardOpenedShellCheck()) {
            final long startTime = System.currentTimeMillis();
            final long endTime = startTime + waitTimeout;
            waitFor(50);
            if (System.currentTimeMillis() >= endTime) {
                return;
            }
        }
    }

    public static void exist(ViewInteraction item) {
        item.check(matches(isDisplayed()));
    }

    public static void typeT(ViewInteraction item, String text) {
        item.perform(typeText(text));
    }

    public static void existClickable(ViewInteraction item) {
        item.check(matches(isDisplayed()));
        item.check(matches(isClickable()));
    }

    public static void existNotClickable(ViewInteraction item) {
        item.check(matches(isDisplayed()));
        item.check(matches(not(isClickable())));
    }

    public static void existText(ViewInteraction item, String text) {
        item.check(matches(isDisplayed()));
        item.check(matches(withText(text)));
    }

    public static void existClickableHint(ViewInteraction item, String text) {
        item.check(matches(isDisplayed()));
        item.check(matches(isClickable()));
        item.check(matches(withHint(text)));
    }

    public static void existClickableText(ViewInteraction item, String text) {
        item.check(matches(isDisplayed()));
        item.check(matches(isClickable()));
        item.check(matches(withText(text)));
    }

    public static void existNotClickableText(ViewInteraction item, String text) {
        item.check(matches(isDisplayed()));
        item.check(matches(not(isClickable())));
        item.check(matches(withText(text)));
    }

    public static void clickBack() {
        onView(isRoot()).perform(pressBack());
    }

    public static void pause() {
        onView(isRoot()).perform(waitFor(5500));
    }

    public static void pauseShort() {
        onView(isRoot()).perform(waitFor(1000));
    }

    public static void pauseSSt() {
        onView(isRoot()).perform(waitFor(750));
    }

    public static Matcher<Root> isPopupWindow() {
        return isPlatformPopup();
    }

    public static ViewAction waitId(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);
                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

    public static ViewAction waitId(final String viewText, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
//                return "wait for a specific view with id <" + viewText + "> during " + millis + " millis.";
                return "wait up to " + millis + " for the view to have text" + viewText;
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withText(viewText);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);
                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

    public static Matcher<View> hasChildren(final Matcher<Integer> numChildrenMatcher) {
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View view) {
                return view instanceof ViewGroup && numChildrenMatcher.matches(((ViewGroup) view).getChildCount());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(" a view with # children is ");
                numChildrenMatcher.describeTo(description);
            }
        };
    }

    public static class ToastMatcher extends TypeSafeMatcher<Root> {
        @Override
        public void describeTo(Description description) {
            description.appendText("is toast");
        }

        @Override
        public boolean matchesSafely(Root root) {
            int type = root.getWindowLayoutParams().get().type;
            if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
                IBinder windowToken = root.getDecorView().getWindowToken();
                IBinder appToken = root.getDecorView().getApplicationWindowToken();
                if (windowToken == appToken) {
                    //means this window isn't contained by any other windows.
                    return true;
                }
            }
            return false;
        }
    }

    public static Matcher<View> hasTextInputLayout(final String expectedErrorText) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextInputLayout)) {
                    return false;
                }
                CharSequence error = ((TextInputLayout) view).getHint();
                if (error == null) {
                    return false;
                }
                String hint = error.toString();
                return expectedErrorText.equals(hint);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static ViewAction customSwipeUp() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER, GeneralLocation.TOP_RIGHT, Press.FINGER);
    }

    public static boolean isKeyboardOpenedShellCheck() {
        String checkKeyboardCmd = "dumpsys input_method | grep mInputShown";
        try {
            return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                    .executeShellCommand(checkKeyboardCmd).contains("mInputShown=true");
        } catch (IOException e) {
            throw new RuntimeException("Keyboard check failed", e);
        }
    }
}

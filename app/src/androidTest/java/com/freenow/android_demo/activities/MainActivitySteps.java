
package com.freenow.android_demo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.view.View;
import android.widget.EditText;

import com.freenow.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.internal.matchers.TypeSafeMatcher;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import android.support.test.espresso.Espresso;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.not;
import static java.lang.Thread.sleep;

public class MainActivitySteps {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Activity activity;

    @Before
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getInstrumentation().getUiAutomation().executeShellCommand(
                    "pm grant " + getTargetContext().getPackageName()
                            + " android.permission.ACCESS_FINE_LOCATION");
        }
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^I am on login screen")
    public void I_am_on_login_screen() {
        assertNotNull(activity);
    }

    @When("^I input username (\\S+)$")
    public void I_input_email(final String username) throws InterruptedException {
    	sleep(2000);
        // Enters the username
        Espresso.onView(withId(R.id.edt_username)).perform(typeText(username), closeSoftKeyboard());
    }

    @When("^I input password \"(.*?)\"$")
    public void I_input_password(final String password) throws InterruptedException {
        Espresso.onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
        sleep(2000);

    }

    @When("^I press login button$")
    public void I_press_submit_button() throws InterruptedException {

        Espresso.onView(withId(R.id.btn_login)).perform(click());
        sleep(2000);
    }

    @Given("^I am on main screen$")
    public void i_am_on_main_screen() throws Throwable {
        assertNotNull(activity);
    }

    @Then("^I type the driver name as (\\S+)$")
    public void I_should_see_error_on_the_editTextView(final String drivername) throws InterruptedException {
        sleep(3000);
        // Enters the search text
        Espresso.onView(withId(R.id.textSearch)).perform(typeText(drivername));
    }

    @Then("^I click on the search result (\\S+)$")
    public void I_should_see_errosr_on_the_editTextView(final String resultNumber) throws InterruptedException {
        sleep(2000);
        int val = Integer.parseInt(resultNumber)-1;
        Espresso.onData(Matchers.anything()).inRoot(RootMatchers.isPlatformPopup()).atPosition(val).perform(ViewActions.click());
        sleep(2000);
    }



    @When("^I click on call button$")
    public void I_press_subsmit_button() throws InterruptedException {

        onView(withId(R.id.fab)).perform(click());
        sleep(5000);
    }


}

package com.freenow.android_demo.activities;



import static android.support.test.espresso.matcher.ViewMatchers.withId;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;


import com.freenow.android_demo.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public String userName = "crazydog335";
    public String password = "venture";
    public String searchText = "Sa";
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void loginTest() throws InterruptedException {
        Thread.sleep(10000);
        // Enters the username
        Espresso.onView(withId(R.id.edt_username)).perform(typeText(userName));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // Enters the pasword
        Espresso.onView(withId(R.id.edt_password)).perform(typeText(password));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // Click on the Login button
        Espresso.onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(5000);
    }


    @Test
    public void searchDriverAndCall() throws InterruptedException {
        Thread.sleep(10000);
        // Enters the search text
        Espresso.onView(withId(R.id.textSearch)).perform(typeText(searchText));
        Thread.sleep(5000);
        Espresso.onData(Matchers.anything()).inRoot(RootMatchers.isPlatformPopup()).atPosition(1).perform(ViewActions.click());
        Thread.sleep(5000);
        Espresso.onView(withId(R.id.fab)).perform(click());
        Thread.sleep(5000);

    }



}

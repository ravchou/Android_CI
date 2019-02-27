package com.mytaxi.android_demo;

import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.mytaxi.android_demo.activities.MainActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.IOException;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 * The test will login to My taxi App and call the driver with name like sa
 */

@RunWith(AndroidJUnit4.class)
public class MyTaxi {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

        //The Method will login to the my taxi app on the anroid device with the given user name and password
        @Before
        public void init(){

        }

       //The test will login to mytaxi app and call the taxi with the name like 'sa'
        @Test
        public void callTaxi() throws Exception {
            onView(withId(R.id.edt_username)).check(matches(isDisplayed())).perform(typeText("crazydog335"));
            onView(withId(R.id.edt_password)).check(matches(isDisplayed())).perform(typeText("venture"));
            onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
            Thread.sleep(3000);
            onView(withId(R.id.textSearch)).check(matches(isDisplayed())).perform(typeText("sa"));
            Thread.sleep(3000);
            onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
            Thread.sleep(2000);
            onView(withId(R.id.fab)).check(matches(isDisplayed())).perform(click());
            Thread.sleep(5000);
            onView(withContentDescription("dial")).check(matches(isDisplayed())).perform(click());
            Thread.sleep(5000);
            //onView(withContentDescription("End")).perform(click());
        }

        //As part of the excepion or after every successfull call the account will be logged off
        @After
        public  void Teardown() throws Exception{
           onView(withContentDescription("Open navigation drawer")).check(matches(isDisplayed())).perform(click());
           onView(withId(R.id.design_menu_item_text)).check(matches(isDisplayed())).perform(click());
        }
}

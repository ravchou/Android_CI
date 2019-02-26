package com.mytaxi.android_demo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.AdapterView;

import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBackUnconditionally;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withSubstring;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.v4.content.ContextCompat.startActivity;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    public ExampleInstrumentedTest() {
        IdlingPolicies.setMasterPolicyTimeout(3000, TimeUnit.SECONDS);
    }

    @Before
    public void init(){

    }
    @Test
    public void Login() throws InterruptedException , IOException{
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));;
    }

    @Test

    public void useAppContext() throws Exception {
        //onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        //onView(withId(R.id.edt_password)).perform(typeText("venture"));
        //onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.textSearch)).perform(typeText("sa"));
        Thread.sleep(3000);
        onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.fab)).perform(click());
        Thread.sleep(5000);
        onView(withContentDescription("dial")).perform(click());
        Thread.sleep(5000);
        //onView(withContentDescription("End")).perform(click());



    }
        //onData(equalTo("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //onData(instanceOf("Sarah Scott".class)).inRoot(RootMatchers.withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).perform(ViewActions.click());
        //onView(allOf(withId(R.id.textSearch), withSubstring("Sarah"))).check(matches(isDisplayed()));

        //onData(allOf(is(instanceOf(String.class)), is("Sarah Scott"))).perform(click());

        //onView(withText("Sarah Scott")).check(matches(isDisplayed())).perform(click());

        //onData(hasItem("Sarah Scott")).perform(click());
        //onData(anything()).inAdapterView(withClassName(equalTo("android.widget.EditText")).atPosition(1).perform(click()));
        //onData(anything()).inAdapterView(isDescendantOfA(withId(R.id.textSearch))).atPosition(2).perform(click());
        //assertEquals("com.mytaxi.android_demo", appContext.getPackageName());



     @After
  public  void Teardown() throws Exception{
       onView(withContentDescription("Open navigation drawer")).perform(click());
    onView(withId(R.id.design_menu_item_text)).perform(click());
}
}

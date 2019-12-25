package com.example.rovermore.unsplashapp

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.runner.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.example.rovermore.unsplashapp.screen.detail.DetailActivity
import com.example.rovermore.unsplashapp.screen.main.MainActivity
import com.example.rovermore.unsplashapp.screen.main.MainAdapter
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityIntentClickTest: AndroidJUnitRunner() {

    @Rule
    @JvmField
    var mActivityRule: IntentsTestRule<MainActivity> = IntentsTestRule(
        MainActivity::class.java
    )

    @Before
    fun stubAllExternalIntents() {
        Intents.intending(CoreMatchers.not(IntentMatchers.isInternal()))
            .respondWith(ActivityResult(Activity.RESULT_OK, null))
    }

    @Test
    fun testClickRecyclerViewItem() {
        Espresso.onView(ViewMatchers.withId(R.id.mainRecyclerView)).perform(
            RecyclerViewActions
                .actionOnItemAtPosition<MainAdapter.MyViewHolder>(0, ViewActions.click())
        )


        Intents.intended(
            AllOf.allOf(
                IntentMatchers.hasComponent(DetailActivity::class.java.name)
            )
        )
    }

    @Test
    fun testRecyclerViewDisplays(){
        Espresso.onView(ViewMatchers.withId(R.id.mainRecyclerView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
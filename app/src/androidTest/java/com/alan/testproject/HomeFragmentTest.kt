package com.alan.testproject

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alan.testproject.fragment.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    @Test
    fun launchFragmentAndVerifyUI() {
        // use launchInContainer to launch the fragment with UI
        launchFragmentInContainer<HomeFragment>()

        // now use espresso to look for the fragment's text view and verify it is displayed
        Espresso.onView(ViewMatchers.withId(R.id.tv_home_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("HOME")));
    }
}
package com.example.moviecataloge.presentation.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.moviecataloge.R
import com.example.moviecataloge.utils.DataDummy
import com.example.moviecataloge.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvshow = DataDummy.generateDummyTv()

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource())
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size - 1
            )
        )
    }

    @Test
    fun loadTvshow() {
        onView(withId(R.id.navigation_tv)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvshow.size - 1
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.img_movie_main)).check(matches(isDisplayed()))
        onView(withId(R.id.img_movie_second)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_movie)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_date_movie)).check(matches(withText(dummyMovie[0].date)))
        onView(withId(R.id.rating)).check(matches(withText(dummyMovie[0].rate)))
        onView(withId(R.id.tv_content_movie)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadDetailTvshow() {
        onView(withId(R.id.navigation_tv)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.img_tvshow_main)).check(matches(isDisplayed()))
        onView(withId(R.id.img_tvshow_second)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_tvshow)).check(matches(withText(dummyTvshow[0].title)))
        onView(withId(R.id.date_tvshow)).check(matches(withText(dummyTvshow[0].date)))
        onView(withId(R.id.rating)).check(matches(withText(dummyTvshow[0].rate)))
        onView(withId(R.id.tv_content_tvshow)).check(matches(withText(dummyTvshow[0].overview)))
    }

    @Test
    fun loadFavoriteMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.img_movie_main)).check(matches(isDisplayed()))
        onView(withId(R.id.img_movie_second)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_movie)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_date_movie)).check(matches(withText(dummyMovie[0].date)))
        onView(withId(R.id.rating)).check(matches(withText(dummyMovie[0].rate)))
        onView(withId(R.id.tv_content_movie)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun loadFavoriteTvshow() {
        onView(withId(R.id.navigation_tv)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_favorite_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.img_tvshow_main)).check(matches(isDisplayed()))
        onView(withId(R.id.img_tvshow_second)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_tvshow)).check(matches(withText(dummyTvshow[0].title)))
        onView(withId(R.id.date_tvshow)).check(matches(withText(dummyTvshow[0].date)))
        onView(withId(R.id.rating)).check(matches(withText(dummyTvshow[0].rate)))
        onView(withId(R.id.tv_content_tvshow)).check(matches(withText(dummyTvshow[0].overview)))
    }

}
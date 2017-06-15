package com.test.premier.network

import io.reactivex.Observable
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import rx.Subscription

class MoviesClientImplTest {

    @Rule @JvmField
    val rule = MockitoJUnit.rule()!!

    @Mock
    lateinit var service: TheMovieDbService

    @Mock
    lateinit var observable: Observable<MoviesResponse>

    internal lateinit var underTest: MoviesClient

    @Before
    fun setUp() {
        underTest = MoviesClientImpl(service)
        //Mockito.`when`(observable.)
    }

    @Test
    fun `when top movies are requested, should call retrofit service and return response`() {
        Mockito.`when`(service.getTopRatedMovies()).thenReturn(observable)

        val result = underTest.requestTopMovies()

        assertTrue(result is Subscription)
    }
}
package com.test.premier.network

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnit
import rx.Observable

class MoviesClientImplTest{

    @Rule @JvmField
    val rule = MockitoJUnit.rule()!!

    @Mock
    lateinit var service: TheMovieDbService

    @Mock
    lateinit var response: Observable<MoviesResponse>

    internal lateinit var underTest: MoviesClient

    @Before
    fun setUp() {
        underTest = MoviesClientImpl(service)
        Mockito.`when`(service.getTopRatedMovies()).thenReturn(response)
    }

    @Test
    fun `when top movies are requested, should call retrofit service and return response`() {
        val result = underTest.requestTopMovies()

        assertThat(result, `is`(response))
        verify(service).getTopRatedMovies()
        verifyNoMoreInteractions(service)
    }
}
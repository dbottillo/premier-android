package com.test.premier.network

import io.reactivex.Observable
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
    }

    @Test
    fun `when top movies are requested, should call retrofit service and return response`() {
        Mockito.`when`(service.getTopRatedMovies()).thenReturn(observable)

        val result = underTest.fetchTopMovies()

        assertThat(result, `is`(observable))
        verify(service).getTopRatedMovies()
        verifyNoMoreInteractions(service)
    }
}
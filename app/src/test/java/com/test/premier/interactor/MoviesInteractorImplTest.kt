package com.test.premier.interactor

import com.test.premier.RxImmediateSchedulerRule
import com.test.premier.domain.Movie
import com.test.premier.network.MovieResponse
import com.test.premier.network.MoviesClient
import com.test.premier.network.MoviesResponse
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class MoviesInteractorImplTest {

    @Rule @JvmField
    val rule = MockitoJUnit.rule()!!

    @Rule @JvmField var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    lateinit var client: MoviesClient

    @Mock
    lateinit var observable: Observable<MoviesResponse>

    internal lateinit var underTest: MoviesInteractor

    @Mock
    lateinit var movies: List<Movie>

    @Before
    fun setUp() {
        underTest = MoviesInteractorImpl(client)
    }

    @Test
    fun `when top movies are requested, should call retrofit service and return response`() {
        val movieResponse = MoviesResponse(0, 0, 0, listOf(
                MovieResponse("id1", "title1", "/backdrop1", "Overview1", "release date1"),
                MovieResponse("id2", "title2", "/backdrop2", "Overview2", "release date2")))
        Mockito.`when`(client.fetchTopMovies()).thenReturn(Observable.just(movieResponse))

        val result = underTest.requestTopMovies()

        val testObserver = TestObserver<List<Movie>>()
        result.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val listResult = testObserver.values()[0]
        assertThat(listResult.size, `is`(2))
        assertThat(listResult[0].title, `is`("title1"))
        assertThat(listResult[0].image, `is`("https://image.tmdb.org/t/p/w342/backdrop1"))
        assertThat(listResult[0].text, `is`("Overview1"))
        assertThat(listResult[1].title, `is`("title2"))
        assertThat(listResult[1].image, `is`("https://image.tmdb.org/t/p/w342/backdrop2"))
        assertThat(listResult[1].text, `is`("Overview2"))
    }


}
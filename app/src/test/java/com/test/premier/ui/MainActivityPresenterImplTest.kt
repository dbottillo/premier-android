package com.test.premier.ui

import com.test.premier.domain.Movie
import com.test.premier.interactor.MoviesCallback
import com.test.premier.interactor.MoviesInteractor
import com.test.premier.interactor.MoviesInteractorImpl
import com.test.premier.network.MoviesClient
import com.test.premier.network.MoviesResponse
import io.reactivex.disposables.Disposable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnit
import rx.Observable

class MainActivityPresenterImplTest {

    @Rule @JvmField
    val rule = MockitoJUnit.rule()!!

    @Mock
    lateinit var client: MoviesClient

    @Mock
    lateinit var view: MainActivityView

    @Mock
    lateinit var interactor: MoviesInteractor

    @Mock
    lateinit var movies: List<Movie>

    @Mock
    lateinit var disposable: Disposable

    internal lateinit var underTest: MainActivityPresenterImpl

    @Before
    fun setUp() {
        underTest = MainActivityPresenterImpl(interactor)
        underTest.init(view)
    }

    @Test
    fun `when top movies are requested, should call interactor and display loading view`() {
        Mockito.`when`(interactor.requestTopMovies(underTest)).thenReturn(disposable)

        underTest.requestTopMovies()

        verify(view).showLoading()
        verify(interactor).requestTopMovies(underTest)
        verifyNoMoreInteractions(view, interactor)
    }

    @Test
    fun `when callback is called successfully should remove the loading and display the movies`() {
        underTest.onSuccess(movies)

        verify(view).hideLoading()
        verify(view).showMovies(movies)
        verifyNoMoreInteractions(view, interactor)
    }

    @Test
    fun `when callback is called unsuccessfully should remove the loading and display an error`() {
        underTest.onError()

        verify(view).hideLoading()
        verify(view).showImpossibileToFetchMovies()
        verifyNoMoreInteractions(view, interactor)
    }
}
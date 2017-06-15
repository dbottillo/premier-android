package com.test.premier.dagger

import com.test.premier.network.MoviesClient
import com.test.premier.network.MoviesClientImpl
import com.test.premier.network.TheMovieDbService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesClient(service: TheMovieDbService): MoviesClient {
        return MoviesClientImpl(service)
    }

    @Provides
    @Singleton
    fun providesMoviesService(client: OkHttpClient): TheMovieDbService {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(TheMovieDbService::class.java)
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }
}
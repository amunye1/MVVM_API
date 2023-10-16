package com.tc.beerlist.di

import com.tc.beerlist.data.remote.ApiDetails
import com.tc.beerlist.data.remote.ApiRequest
import com.tc.beerlist.data.repository.Repository
import com.tc.beerlist.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // defines the imports for HILT -> What needs to be injected
@InstallIn(SingletonComponent::class) //defines the scope of those injections defined here
class AppModule {
    //OkHttp - Loggers - Interceptors
    @Provides
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    }
    //Retrofit -Builder
    @Provides
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()
        )
        .client(client)
        .build()

    //API class
    @Provides
    fun provideApiCall(retrofit: Retrofit):ApiRequest = retrofit.create(ApiRequest::class.java)
    //Repository

    @Provides
    fun provideRepository(api: ApiRequest): Repository =RepositoryImpl(api)
}
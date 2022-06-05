package com.example.yelptwo.di

import com.example.yelptwo.api.RetrofitFactory
import com.example.yelptwo.api.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit = Retrofit.Builder().baseUrl(RetrofitService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideRestaurantServiceApi(retrofit: Retrofit): RetrofitService
    {
        return retrofit.create(RetrofitService::class.java)
    }


}
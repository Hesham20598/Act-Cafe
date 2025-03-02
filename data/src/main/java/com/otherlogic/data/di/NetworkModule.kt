package com.otherlogic.data.di

import com.google.gson.Gson
import com.otherlogic.data.api.ActServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): ActServices {
        return Retrofit.Builder()
            .baseUrl("https://myres.me/qr_menu/api/") // live url
//            .baseUrl("https://myres.me/happyjoes_test/api/") // test url
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
            .create(ActServices::class.java)
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY // Set logging level
        return interceptor
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gson = Gson()
        return gson
    }
}


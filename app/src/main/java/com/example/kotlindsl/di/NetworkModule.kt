package com.example.kotlindsl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * description:
 * create by HuangLin
 * on 2020/12/3
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
    }

    @Provides
    @Singleton
    fun provideMap(): Map<String, String> {
        val hashMap = hashMapOf<String, String>()
        hashMap["huang"] = "lin"
        return hashMap
    }

    @Provides
    @Singleton
    fun provideSource(): NetDataSource {
        return NetDataSource()
    }
}

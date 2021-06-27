package com.ae.acronymapp.core.di

import com.ae.acronymapp.data.remote.service.SearchCriteriaService
import com.ae.acronymapp.util.CheckConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    /**
     * Provide SearchCriteriaService
     */
    @Provides
    fun provideSearchCriteriaService(retrofit: Retrofit): SearchCriteriaService {
        return retrofit.create(SearchCriteriaService::class.java)
    }

    /**
     * Provide CheckConnection
     */
    @Provides
    fun provideCheckConnection(): CheckConnection {
        return CheckConnection()
    }
}

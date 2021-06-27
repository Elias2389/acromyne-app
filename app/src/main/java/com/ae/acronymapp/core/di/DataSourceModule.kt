package com.ae.acronymapp.core.di

import android.content.Context
import androidx.room.Room
import com.ae.acronymapp.data.datasource.searchcriteria.local.LocalDataSourceSearchCriteria
import com.ae.acronymapp.data.datasource.searchcriteria.local.LocalDataSourceSearchCriteriaImpl
import com.ae.acronymapp.data.datasource.searchcriteria.remote.RemoteDataSourceSearchCriteria
import com.ae.acronymapp.data.datasource.searchcriteria.remote.RemoteDataSourceSearchCriteriaImpl
import com.ae.acronymapp.data.local.AppDatabase
import com.ae.acronymapp.data.local.dao.MeaningResponseDao
import com.ae.acronymapp.data.remote.service.SearchCriteriaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    private const val DB_NAME: String = "meanings_db"

    /**
     * Provide AppDatabase
     */
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }

    /**
     * Provide MeaningResponseDao
     */
    @Provides
    fun provideMeaningResponseDao(appDatabase: AppDatabase): MeaningResponseDao {
        return appDatabase.meaningDao()
    }

    /**
     * Provide RemoteDataSourceSearchCriteria
     */
    @Provides
    fun provideRemoteDataSourceSearchCriteria(service: SearchCriteriaService): RemoteDataSourceSearchCriteria {
        return RemoteDataSourceSearchCriteriaImpl(service)
    }

    /**
     * Provide LocalDataSourceSearchCriteria
     */
    @Provides
    fun provideLocalDataSourceSearchCriteria(dao: MeaningResponseDao): LocalDataSourceSearchCriteria {
        return LocalDataSourceSearchCriteriaImpl(dao)
    }
}

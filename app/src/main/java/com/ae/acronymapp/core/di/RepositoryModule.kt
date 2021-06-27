package com.ae.acronymapp.core.di

import com.ae.acronymapp.data.datasource.searchcriteria.local.LocalDataSourceSearchCriteria
import com.ae.acronymapp.data.datasource.searchcriteria.remote.RemoteDataSourceSearchCriteria
import com.ae.acronymapp.ui.searchcriteria.repository.SearchCriteriaRepository
import com.ae.acronymapp.ui.searchcriteria.repository.SearchCriteriaRepositoryImpl
import com.ae.acronymapp.util.CheckConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object RepositoryModule {

    /**
     * Provide SearchCriteriaRepository
     */
    @Provides
    @ViewModelScoped
    fun provideSearchCriteriaRepository(
        remote: RemoteDataSourceSearchCriteria,
        local: LocalDataSourceSearchCriteria,
        internetStatus: CheckConnection
    ): SearchCriteriaRepository {
        return SearchCriteriaRepositoryImpl(remote, local, internetStatus)
    }
}

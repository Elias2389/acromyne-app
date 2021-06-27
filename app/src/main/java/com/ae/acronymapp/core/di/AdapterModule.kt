package com.ae.acronymapp.core.di

import com.ae.acronymapp.ui.searchcriteria.adapter.CustomFilter
import com.ae.acronymapp.ui.searchcriteria.adapter.SearchMeaningAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AdapterModule {

    /**
     * Provide CustomFilter
     */
    @Provides
    fun provideCustomFilter(): CustomFilter {
        return CustomFilter()
    }

    /**
     * Provide SearchMeaningAdapter
     */
    @Provides
    fun provideSearchMeaningAdapter(customFilter: CustomFilter): SearchMeaningAdapter {
        return SearchMeaningAdapter(customFilter)
    }
}

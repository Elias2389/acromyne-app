package com.ae.acronymapp.data.datasource.searchcriteria.remote

import com.ae.acronymapp.data.remote.service.SearchCriteriaService
import com.ae.acronymapp.dto.MeaningResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceSearchCriteriaImpl @Inject constructor(
    private val service: SearchCriteriaService
) : RemoteDataSourceSearchCriteria {
    override suspend fun getMeaningsByCriteria(criteria: String): List<MeaningResponse> {
        return service.getMeanings(criteria)
    }
}

package com.ae.acronymapp.ui.searchcriteria.repository

import com.ae.acronymapp.data.datasource.searchcriteria.local.LocalDataSourceSearchCriteria
import com.ae.acronymapp.data.datasource.searchcriteria.remote.RemoteDataSourceSearchCriteria
import com.ae.acronymapp.dto.MeaningResponse
import com.ae.acronymapp.util.CheckConnection
import com.ae.acronymapp.util.toMeaningResponse
import com.ae.acronymapp.util.toMeaningResponseEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchCriteriaRepositoryImpl @Inject constructor(
    private val remote: RemoteDataSourceSearchCriteria,
    private val local: LocalDataSourceSearchCriteria,
    private val internetStatus: CheckConnection
) : SearchCriteriaRepository {

    override suspend fun getMeaningsByCriteria(criteria: String): List<MeaningResponse> {
        return if (internetStatus.connectionIsAvailable()) {
            remote.getMeaningsByCriteria(criteria).forEach {
                local.saveMeanings(it.toMeaningResponseEntity())
            }
            local.getMeaningsByCriteriaLocal(criteria).toMeaningResponse()
        } else {
            local.getMeaningsByCriteriaLocal(criteria).toMeaningResponse()
        }
    }

    override suspend fun getAllMeanings(): List<MeaningResponse> {
        return local.getAllMeaningLocal().toMeaningResponse()
    }
}

package com.ae.acronymapp.data.datasource.searchcriteria.local

import com.ae.acronymapp.data.local.entity.MeaningResponseEntity

interface LocalDataSourceSearchCriteria {
    /**
     * Get meanings by criteria from DB
     * @param criteria to search
     * @return result of search
     */
    suspend fun getMeaningsByCriteriaLocal(criteria: String): List<MeaningResponseEntity>

    /**
     * Get all meanings from DB
     * @return result of search
     */
    suspend fun getAllMeaningLocal(): List<MeaningResponseEntity>

    /**
     * Insert meaning from DB
     * @param meaningResponse
     */
    suspend fun saveMeanings(meaningResponse: MeaningResponseEntity)
}

package com.ae.acronymapp.data.datasource.searchcriteria.remote

import com.ae.acronymapp.dto.MeaningResponse

interface RemoteDataSourceSearchCriteria {

    /**
     * Get meanings from API
     * @param criteria to search
     * @return result of search
     */
    suspend fun getMeaningsByCriteria(criteria: String): List<MeaningResponse>
}

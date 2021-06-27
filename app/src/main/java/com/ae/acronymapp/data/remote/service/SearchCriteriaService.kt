package com.ae.acronymapp.data.remote.service

import com.ae.acronymapp.dto.MeaningResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchCriteriaService {

    /**
     * Get list of meanings
     * by criteria
     */
    @GET("dictionary.py")
    suspend fun getMeanings(
        @Query("sf") sf: String
    ): List<MeaningResponse>
}

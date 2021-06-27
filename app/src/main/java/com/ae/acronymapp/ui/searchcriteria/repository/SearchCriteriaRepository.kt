package com.ae.acronymapp.ui.searchcriteria.repository

import com.ae.acronymapp.dto.MeaningResponse

interface SearchCriteriaRepository {
    /**
     * Get meanings by criteria
     * @param criteria to search
     * @return result of search
     */
    suspend fun getMeaningsByCriteria(criteria: String): List<MeaningResponse>

    /**
     * Get all meanings
     * @return result of search
     */
    suspend fun getAllMeanings(): List<MeaningResponse>
}

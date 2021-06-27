package com.ae.acronymapp.data.local.dao

import androidx.room.* // ktlint-disable no-wildcard-imports
import com.ae.acronymapp.data.local.entity.MeaningResponseEntity

@Dao
interface MeaningResponseDao {
    /**
     * Method to get al meanings from DB
     *
     * @return results
     */
    @Query("SELECT * FROM meaning_entity")
    suspend fun getAllMeanings(): List<MeaningResponseEntity>

    /**
     * Method to get al meanings from DB by criteria
     *
     * @return results
     */
    @Query("SELECT * FROM meaning_entity WHERE abbreviation = :criteria")
    suspend fun getAllMeaningsByCriteria(criteria: String): List<MeaningResponseEntity>

    /**
     * Insert results in DB
     *
     * @param meaning
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeaning(meaning: MeaningResponseEntity)
}

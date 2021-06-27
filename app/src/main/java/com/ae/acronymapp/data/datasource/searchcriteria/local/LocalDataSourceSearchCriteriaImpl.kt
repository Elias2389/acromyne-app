package com.ae.acronymapp.data.datasource.searchcriteria.local

import com.ae.acronymapp.data.local.dao.MeaningResponseDao
import com.ae.acronymapp.data.local.entity.MeaningResponseEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceSearchCriteriaImpl @Inject constructor(
    private val dao: MeaningResponseDao
) : LocalDataSourceSearchCriteria {

    override suspend fun getMeaningsByCriteriaLocal(criteria: String): List<MeaningResponseEntity> {
        return dao.getAllMeaningsByCriteria(criteria)
    }

    override suspend fun getAllMeaningLocal(): List<MeaningResponseEntity> {
        return dao.getAllMeanings()
    }

    override suspend fun saveMeanings(meaningResponse: MeaningResponseEntity) {
        dao.insertMeaning(meaningResponse)
    }
}

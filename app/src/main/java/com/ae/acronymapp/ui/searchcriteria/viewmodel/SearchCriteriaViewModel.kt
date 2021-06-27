package com.ae.acronymapp.ui.searchcriteria.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ae.acronymapp.common.resource.Resource
import com.ae.acronymapp.common.resource.ResponseHandler
import com.ae.acronymapp.dto.MeaningResponse
import com.ae.acronymapp.ui.searchcriteria.repository.SearchCriteriaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SearchCriteriaViewModel @Inject constructor(
    private val repository: SearchCriteriaRepository
) : ViewModel() {

    fun getMeaningsByCriteria(criteria: String): LiveData<Resource<List<MeaningResponse>>> = liveData {
        emit(Resource.loading(null))
        try {
            val response = repository.getMeaningsByCriteria(criteria)
            emit(ResponseHandler.handleSuccess(response))
        } catch (e: Exception) {
            emit(ResponseHandler.handleException<List<MeaningResponse>>(e))
        }
    }

    fun getLastSearches(): LiveData<Resource<List<MeaningResponse>>> = liveData {
        emit(Resource.loading(null))
        try {
            val response = repository.getAllMeanings()
            emit(ResponseHandler.handleSuccess(response))
        } catch (e: Exception) {
            emit(ResponseHandler.handleException<List<MeaningResponse>>(e))
        }
    }
}

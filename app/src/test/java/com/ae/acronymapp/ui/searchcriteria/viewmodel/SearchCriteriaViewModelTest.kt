package com.ae.acronymapp.ui.searchcriteria.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ae.acronymapp.common.resource.Resource
import com.ae.acronymapp.common.resource.ResponseHandler
import com.ae.acronymapp.dto.MeaningResponse
import com.ae.acronymapp.ui.searchcriteria.repository.SearchCriteriaRepository
import com.ae.acronymapp.util.getListMeaningResponseMock
import com.ae.acronymapp.util.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.* // ktlint-disable no-wildcard-imports
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchCriteriaViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Mock
    lateinit var repository: SearchCriteriaRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<MeaningResponse>>>

    private lateinit var viewModel: SearchCriteriaViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        viewModel = SearchCriteriaViewModel(repository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Get meaning by criteria should be success`() {
        testCoroutineDispatcher.runBlockingTest {
            val resultExpect = getListMeaningResponseMock()
            val search = "HMM"
            BDDMockito.given(repository.getMeaningsByCriteria(search)).willReturn(resultExpect)

            viewModel.getMeaningsByCriteria(search).observeForever(observer)
            viewModel.getMeaningsByCriteria(search).getOrAwaitValue()

            Mockito.verify(observer).onChanged(Resource.loading(null))
            viewModel.getMeaningsByCriteria(search).getOrAwaitValue()

            Mockito.verify(observer)
                .onChanged(ResponseHandler.handleSuccess(resultExpect))
        }
    }

    @ExperimentalCoroutinesApi
    @Test(expected = Exception::class)
    fun `Get meanings by criteria should be error`() {
        testCoroutineDispatcher.runBlockingTest {
            val resultExpect = Exception()
            val search = "HMM"
            BDDMockito.given(repository.getMeaningsByCriteria(search)).willThrow(resultExpect)

            viewModel.getMeaningsByCriteria(search).observeForever(observer)
            viewModel.getMeaningsByCriteria(search).getOrAwaitValue()

            Mockito.verify(observer).onChanged(Resource.loading(null))
            viewModel.getMeaningsByCriteria(search).getOrAwaitValue()

            Mockito.verify(observer)
                .onChanged(ResponseHandler.handleException(resultExpect))
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Get last searches should be success`() {
        testCoroutineDispatcher.runBlockingTest {
            val resultExpect = getListMeaningResponseMock()
            BDDMockito.given(repository.getAllMeanings()).willReturn(resultExpect)

            viewModel.getLastSearches().observeForever(observer)
            viewModel.getLastSearches().getOrAwaitValue()

            Mockito.verify(observer)
                .onChanged(ResponseHandler.handleSuccess(resultExpect))
        }
    }

    @ExperimentalCoroutinesApi
    @Test(expected = Exception::class)
    fun `Get last searches should be error`() {
        testCoroutineDispatcher.runBlockingTest {
            val resultExpect = Exception()
            BDDMockito.given(repository.getAllMeanings()).willThrow(resultExpect)

            viewModel.getLastSearches().observeForever(observer)
            viewModel.getLastSearches().getOrAwaitValue()

            Mockito.verify(observer)
                .onChanged(ResponseHandler.handleException(resultExpect))
        }
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }
}

package com.ae.acronymapp.ui.searchcriteria.view

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ae.acronymapp.R
import com.ae.acronymapp.common.base.AbstractActivity
import com.ae.acronymapp.common.resource.Status
import com.ae.acronymapp.databinding.ActivityMainBinding
import com.ae.acronymapp.dto.LongFormArray
import com.ae.acronymapp.ui.searchcriteria.adapter.SearchMeaningAdapter
import com.ae.acronymapp.ui.searchcriteria.viewmodel.SearchCriteriaViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AbstractActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: SearchCriteriaViewModel by viewModels()

    @Inject
    lateinit var searchMeaningAdapter: SearchMeaningAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        getLastSearches()
    }

    private fun setupViews() {
        setRegularContainer(binding.searchRv)
        setEmptyStateView(binding.emptyStateView)
        setupSearchView()
        setupRv()
    }

    private fun getLastSearches() {
        viewModel.getLastSearches().observe(
            this,
            Observer { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        response.data?.let { result ->
                            if (result.isEmpty()) {
                                notFoundLastSearches()
                            } else {
                                val meanings = result[0].longFormArray
                                showData(meanings)
                            }
                        }
                    }
                    Status.ERROR -> {
                        showEmptyState()
                    }
                }
            }
        )
    }

    private fun searchByCriteria(criteria: String) {
        viewModel.getMeaningsByCriteria(criteria.toUpperCase()).observe(
            this,
            Observer { response ->
                when (response.status) {
                    Status.LOADING -> {
                        reloadEmptyState()
                    }
                    Status.SUCCESS -> {
                        response.data?.let { result ->
                            if (result.isEmpty()) {
                                notFoundData()
                            } else {
                                val meanings = result[0].longFormArray
                                showData(meanings)
                            }
                        }
                    }
                    Status.ERROR -> {
                        showEmptyState()
                    }
                }
            }
        )
    }

    private fun setupSearchView() {
        binding.searchMeanings.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchByCriteria(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.isEmpty()) {
                        getLastSearches()
                    } else {
                        searchMeaningAdapter.filter.filter(newText)
                    }
                }

                return false
            }
        })
    }

    private fun setupRv() {
        binding.searchRv.apply {
            adapter = searchMeaningAdapter
            layoutManager = provideLayoutManager()
        }
    }

    private fun provideLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun showData(list: List<LongFormArray>) {
        hideEmptyState()
        searchMeaningAdapter.clearAll()
        searchMeaningAdapter.setLongFormList(list)
    }

    private fun notFoundData() {
        binding.emptyStateView.setMessage(getString(R.string.empty_results_text))
        showEmptyState()
        searchMeaningAdapter.clearAll()
    }

    private fun notFoundLastSearches() {
        binding.emptyStateView.setMessage(getString(R.string.empty_latest_results_text))
        showEmptyState()
        searchMeaningAdapter.clearAll()
    }

    override fun onStop() {
        super.onStop()
        hideKeyboard()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(
            window.decorView.rootView.applicationWindowToken,
            HIDE_KEYBOARD_FLAG
        )
    }

    companion object {
        private const val HIDE_KEYBOARD_FLAG: Int = 0
    }
}

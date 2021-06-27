package com.ae.acronymapp.ui.searchcriteria.adapter

import android.annotation.SuppressLint
import android.widget.Filter
import com.ae.acronymapp.dto.LongFormArray
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomFilter @Inject constructor() : Filter() {
    private var originalList: List<LongFormArray> = arrayListOf()
    private var filteredList: ArrayList<LongFormArray> = arrayListOf()

    private var adapter: SearchMeaningAdapter? = null

    fun setMovieList(longFormArrary: List<LongFormArray>) {
        originalList = longFormArrary
    }

    fun setAdapter(newAdapter: SearchMeaningAdapter) {
        adapter = newAdapter
    }

    @SuppressLint("DefaultLocale")
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        filteredList.clear()
        val results = FilterResults()
        constraint?.let { it ->
            if (it.isEmpty()) {
                filteredList.addAll(originalList)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim()
                originalList.forEach { meanning ->
                    if (meanning.longForm.toLowerCase().contains(filterPattern)) {
                        filteredList.add(meanning)
                    }
                }
            }
        }

        results.values = filteredList
        results.count = filteredList.size
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter?.let {
            it.getLongFormList().clear()
            if (results != null) {
                try {
                    it.getLongFormList().addAll(results.values as ArrayList<LongFormArray>)
                    it.notifyDataSetChanged()
                } catch (error: TypeCastException) {
                    Timber.e(error)
                }
            }
        }
    }
}

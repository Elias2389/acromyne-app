package com.ae.acronymapp.ui.searchcriteria.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.ae.acronymapp.R
import com.ae.acronymapp.databinding.DetailItemBinding
import com.ae.acronymapp.dto.LongFormArray
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchMeaningAdapter @Inject constructor(
    private val customFilter: CustomFilter
) :
    RecyclerView.Adapter<SearchMeaningAdapter.ViewHolder>(), Filterable {
    private var list: ArrayList<LongFormArray> = arrayListOf()
    private var longFormList: ArrayList<LongFormArray> = arrayListOf()

    fun setLongFormList(longForm: List<LongFormArray>) {
        list.addAll(longForm)
        longFormList.addAll(longForm)
        notifyDataSetChanged()
    }

    fun clearAll() {
        longFormList.clear()
        list.clear()
        notifyDataSetChanged()
    }

    fun getLongFormList(): ArrayList<LongFormArray> {
        return longFormList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.detail_item,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return longFormList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(longFormList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = DetailItemBinding.bind(itemView)

        fun bind(item: LongFormArray) {
            binding.detailItemTitle.text = item.longForm
            binding.detailItemOverview.text = item.longForm
        }
    }

    override fun getFilter(): Filter {
        longFormList.clear()
        longFormList.addAll(list)
        customFilter.setAdapter(this)
        customFilter.setMovieList(longFormList)
        return customFilter
    }
}

package com.ae.acronymapp.ui.searchcriteria.adapter

import android.content.Context
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
        holder.bind(longFormList[position], holder.itemView.context)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = DetailItemBinding.bind(itemView)

        fun bind(item: LongFormArray, context: Context) {
            val representativeForm = context.getString(R.string.representative_form_text)
            val frequency = context.getString(R.string.since_text)
            "$representativeForm: ${item.longForm}".also { binding.detailItemTitle.text = it }
            "$frequency: ${item.since}".also { binding.detailItemOverview.text = it }
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

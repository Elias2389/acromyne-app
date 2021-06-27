package com.ae.acronymapp.common.component

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ae.acronymapp.R

/**
 * Component to show empty state
 */
class EmptyState : ConstraintLayout {

    private lateinit var emptyStateText: TextView
    private lateinit var loading: ProgressBar

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inflate(context, R.layout.empty_state_view, this)
        setupViews()
    }

    private fun setupViews() {
        emptyStateText = rootView.findViewById(R.id.empty_state_task_text)
        loading = rootView.findViewById(R.id.empty_state_loading)
    }

    /**
     * Set message of empty state
     * @param message about empty state
     */
    fun setMessage(message: String) {
        emptyStateText.text = message
    }

    /**
     * Method to show empty state
     */
    fun showEmptyState() {
        loading.visibility = GONE
        emptyStateText.visibility = VISIBLE
    }

    /**
     * Method to reload empty state
     */
    fun loadingEmptyState() {
        loading.visibility = VISIBLE
        emptyStateText.visibility = GONE
    }

    /**
     * Method to hide empty state
     */
    fun hideEmptyState() {
        loading.visibility = GONE
        emptyStateText.visibility = GONE
    }
}

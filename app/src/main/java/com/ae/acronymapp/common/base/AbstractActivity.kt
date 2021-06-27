package com.ae.acronymapp.common.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ae.acronymapp.common.component.EmptyState

abstract class AbstractActivity : AppCompatActivity() {

    private lateinit var emptyState: EmptyState
    private lateinit var regularContainer: View

    protected fun setEmptyStateView(emptyStateView: EmptyState) {
        emptyState = emptyStateView
    }

    private fun getEmptyState(): EmptyState = emptyState

    protected fun showEmptyState() {
        getEmptyState().showEmptyState()
        getRegularContainer().visibility = View.GONE
    }

    protected fun reloadEmptyState() {
        getEmptyState().loadingEmptyState()
        getRegularContainer().visibility = View.GONE
    }

    protected fun hideEmptyState() {
        getEmptyState().hideEmptyState()
        getRegularContainer().visibility = View.VISIBLE
    }

    protected fun setMessageEmptyState(message: String) {
        getEmptyState().setMessage(message)
    }

    protected fun setRegularContainer(container: View) {
        regularContainer = container
    }

    private fun getRegularContainer(): View = regularContainer

    protected fun configureEmptyState(rootView: View, container: View, emptyStateView: EmptyState) {
        setContentView(rootView)
        setRegularContainer(container)
        setEmptyStateView(emptyStateView)
    }
}

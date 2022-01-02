package com.example.kolesaparser.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.kolesaparser.R
import com.example.kolesaparser.core.ViewState
import com.example.kolesaparser.domain.models.Car
import com.example.kolesaparser.worker.SEARCH_WORKER_TAG
import com.example.kolesaparser.worker.SearchWorker
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject
import java.util.concurrent.TimeUnit


class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val urlEditText get() = main_url_edit_text
    private val priceEditText get() = main_price_edit_text
    private val applyBtn get() = main_apply_button
    private val recyclerView get() = main_rv

    private val viewModel: MainViewModel by inject()
    private val adapter = ResultItemAdapter {
        onItemClicked(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter
        initClickListeners()
        setupObservers()
    }

    private fun initWorker() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val workRequest =
            PeriodicWorkRequestBuilder<SearchWorker>(15, TimeUnit.MINUTES, 25, TimeUnit.MINUTES)
                .addTag(SEARCH_WORKER_TAG)
                .setInitialDelay(1, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
        WorkManager.getInstance(requireContext())
            .enqueue(workRequest)
    }

    private fun initClickListeners() {
        applyBtn.setOnClickListener {
            viewModel.onUpdateData(
                "https://kolesa.kz/cars/?price[to]=100000000",
                priceEditText.text.toString().toInt()
            )
        }
    }

    private fun onItemClicked(item: Car) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
        startActivity(browserIntent)
    }

    private fun setupObservers() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            handleViewStateChanges(it)
        }
    }

    private fun handleViewStateChanges(state: ViewState<MainViewState>) {
        when (state) {
            is ViewState.Data -> handleDataChanges(state.data)
            is ViewState.Error -> onError(state.error)
            is ViewState.Loading -> onLoading()
        }
    }

    private fun handleDataChanges(state: MainViewState) {
        when (state) {
            is MainViewState.InitialSearchProperties -> applyDataToEditTextFields(
                state.url,
                state.price
            )
            is MainViewState.SearchResult -> applySearchResultData(state.cars)
            MainViewState.WorkerInit -> initWorker()
        }
    }

    private fun applyDataToEditTextFields(url: String, price: Int) {

    }

    private fun applySearchResultData(cars: List<Car>) {
        adapter.submitList(cars)
    }

    private fun onError(error: Throwable) {

    }

    private fun onLoading() {
        TODO("Not yet implemented")
    }
}
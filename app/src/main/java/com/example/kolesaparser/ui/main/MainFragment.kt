package com.example.kolesaparser.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.work.*
import com.example.kolesaparser.R
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

    private val viewModel: MainViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()
        initWorker()
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
                urlEditText.text.toString(),
                priceEditText.text.toString().toInt()
            )
        }
    }
}
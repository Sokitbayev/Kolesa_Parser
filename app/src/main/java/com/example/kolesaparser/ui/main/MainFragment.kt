package com.example.kolesaparser.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kolesaparser.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject

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
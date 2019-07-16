package com.codeerow.presentation.ui.screens.navigation_block_search.transactions

import androidx.fragment.app.DialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_form_dialog.SearchFormViewModel
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultDialogFragment
import com.codeerow.presentation.ui.screens.navigation_block_search.search_result_dialog.SearchResultDialogFragment.Companion.ARG_INITIAL_SEARCH_RESULT
import com.codeerow.spirit.R
import com.codeerow.spirit.navigation.command.ShowDialog
import com.codeerow.spirit.navigation.extensions.navigate


class TransactionsViewModel : SearchFormViewModel() {


    init {
        searchForm.doOnNext(::showSearchResults).subscribeByViewModel()
    }


    fun makeSearch() {
        navigate(ShowDialog(SearchFormDialogFragment().apply { setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen) }))
    }

    private fun showSearchResults(initialSearchResult: String) {
        navigate(ShowDialog(SearchResultDialogFragment().apply { setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen) }) {
            putString(ARG_INITIAL_SEARCH_RESULT, initialSearchResult)
        })
    }
}
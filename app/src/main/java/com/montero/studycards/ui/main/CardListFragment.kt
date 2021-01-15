package com.montero.studycards.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.montero.studycards.R
import com.montero.studycards.viewmodels.CardListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardListFragment : Fragment() {

    private val adapter = CardListAdapter(this)

    private val viewModel : CardListViewModel by activityViewModels()

    companion object {
        fun newInstance() = CardListFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        setUp(view)
        viewModel.cards.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun setUp(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = adapter
    }

}
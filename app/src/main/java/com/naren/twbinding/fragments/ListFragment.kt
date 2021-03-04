package com.naren.twbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.naren.twbinding.R
import com.naren.twbinding.util.EntryListAdapter
import com.naren.twbinding.viewmodel.EntryViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var entryViewModel: EntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryViewModel = ViewModelProvider(this).get(EntryViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(context)
        val entryListAdapter = EntryListAdapter(requireContext())
        recycler_view.adapter = entryListAdapter

        entryViewModel.allEntries.observe(viewLifecycleOwner, Observer {
            entryListAdapter.setEntries(it)
        })


        fab.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToWriteFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }


}
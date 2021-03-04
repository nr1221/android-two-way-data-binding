package com.naren.twbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.naren.twbinding.R
import com.naren.twbinding.databinding.FragmentEditBinding
import com.naren.twbinding.util.OnClickListener
import com.naren.twbinding.util.showMessage
import com.naren.twbinding.viewmodel.EditViewModel
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_write.*


class EditFragment : Fragment(), OnClickListener {

    private lateinit var dataBinding: FragmentEditBinding
    private lateinit var viewModel: EditViewModel
    private var entryId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit, container, false)
        dataBinding.listener = this
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            entryId = EditFragmentArgs.fromBundle(it).id
        }

        viewModel.getSingle(entryId)
        initObservers()
    }

    private fun initObservers() {
        viewModel.singleEntry.observe(viewLifecycleOwner, Observer {
            dataBinding.entry = it
        })
    }

    override fun onClicked(view: View) {
        if ((et_detailsUp.text.toString().isEmpty() || et_titleUp.text.toString().isEmpty())
                || (et_detailsUp.text.toString().isEmpty() && et_titleUp.text.toString().isEmpty())) {
            showMessage(requireContext(), "please fill all the fields")
        } else {
            dataBinding.entry?.let {
                viewModel.updateEntry(it)
                showMessage(requireContext(), "Entry has been updated successfully...")
            }
        }

    }


}
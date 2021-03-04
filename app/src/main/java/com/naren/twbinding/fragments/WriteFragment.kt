package com.naren.twbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.naren.twbinding.R
import com.naren.twbinding.databinding.FragmentWriteBinding
import com.naren.twbinding.util.OnClickListener
import com.naren.twbinding.util.showMessage
import com.naren.twbinding.viewmodel.WriteViewModel
import kotlinx.android.synthetic.main.fragment_write.*

class WriteFragment : Fragment(), OnClickListener {

    private lateinit var writeViewModel: WriteViewModel
    private lateinit var dataBinding: FragmentWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        writeViewModel = ViewModelProvider(this).get(WriteViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_write, container, false)
        dataBinding.model = writeViewModel
        dataBinding.listener = this
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onClicked(view: View) {
        if ((et_details.text.toString().isEmpty() || et_title.text.toString().isEmpty())
                || (et_details.text.toString().isEmpty() && et_title.text.toString().isEmpty())) {
            showMessage(requireContext(), "please fill all the fields")
        } else {
            writeViewModel.onSave()
            showMessage(requireContext(), "Entry has been created successfully...")
        }
    }


}
package com.naren.twbinding.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.naren.twbinding.R
import com.naren.twbinding.data.Entry
import com.naren.twbinding.databinding.EntryLayoutBindingImpl
import com.naren.twbinding.fragments.ListFragmentDirections
import kotlinx.android.synthetic.main.entry_layout.view.*

class EntryListAdapter internal constructor(val context: Context)
    : RecyclerView.Adapter<EntryListAdapter.ViewHolder>() , OnClickListener{

    private var entries = emptyList<Entry>()

    internal fun setEntries(entries: List<Entry>) {
        this.entries = entries
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = DataBindingUtil.inflate<EntryLayoutBindingImpl>(inflater, R.layout.entry_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryListAdapter.ViewHolder, position: Int) {
        holder.view.entry = entries[position]
        holder.view.listener = this
    }

    override fun getItemCount() = entries.size

    class ViewHolder(val view: EntryLayoutBindingImpl) : RecyclerView.ViewHolder(view.root)

    override fun onClicked(view : View) {
        val id = view.txt_id.text.toString().toInt()
        val action = ListFragmentDirections.actionListFragmentToEditFragment(id)
        Navigation.findNavController(view).navigate(action)
    }


}
package com.naren.twbinding.viewmodel

import android.app.Application
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.naren.twbinding.data.Entry
import com.naren.twbinding.data.EntryDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EntryRepository

    init {
        val entryDao = EntryDatabase.buildDatabase(application).entryDao()
        repository = EntryRepository(entryDao)
    }

    var etTitle = ""
    var etDetails = ""

    var titleWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            etTitle = s.toString()
        }

        override fun afterTextChanged(s: Editable?) {}
    }


    var detailsWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            etDetails = s.toString()
        }

        override fun afterTextChanged(s: Editable?) {}
    }


    fun onSave() = insertEntry(Entry(etTitle, etDetails))

    private fun insertEntry(entry: Entry) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(entry)
    }


}
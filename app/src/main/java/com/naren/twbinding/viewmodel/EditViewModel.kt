package com.naren.twbinding.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.naren.twbinding.data.Entry
import com.naren.twbinding.data.EntryDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EntryRepository

    private var entry: MutableLiveData<Entry> = MutableLiveData()
    var singleEntry: LiveData<Entry> = entry

    init {
        val entryDao = EntryDatabase.buildDatabase(application).entryDao()
        repository = EntryRepository(entryDao)
    }

    fun getSingle(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        entry.postValue(repository.getSingle(id))
    }

    fun updateEntry(entry: Entry)  = viewModelScope.launch(Dispatchers.IO) {
        repository.updateEntry(entry)
    }
}
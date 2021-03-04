package com.naren.twbinding.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.naren.twbinding.data.Entry
import com.naren.twbinding.data.EntryDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EntryRepository
    val allEntries: LiveData<List<Entry>>


    init {
        val entryDao = EntryDatabase.buildDatabase(application).entryDao()
        repository = EntryRepository(entryDao)
        allEntries = repository.allEntries
    }


    fun insertEntry(entry: Entry) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(entry)
    }


}
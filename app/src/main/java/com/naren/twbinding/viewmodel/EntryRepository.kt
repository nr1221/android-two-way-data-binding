package com.naren.twbinding.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.naren.twbinding.data.Entry
import com.naren.twbinding.data.EntryDAO
import com.naren.twbinding.data.EntryDatabase

class EntryRepository(private val entryDAO: EntryDAO) {


    val allEntries: LiveData<List<Entry>> = entryDAO.getAllEntries()

    suspend fun insert(entry: Entry) {
        entryDAO.insertEntry(entry)
    }

    suspend fun getSingle(id: Int) = entryDAO.getSingle(id)

    suspend fun updateEntry(entry: Entry) = entryDAO.updateEntry(entry)
}
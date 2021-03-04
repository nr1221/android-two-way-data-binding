package com.naren.twbinding.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface EntryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: Entry)

    @Query("SELECT * FROM entry_table")
    fun getAllEntries(): LiveData<List<Entry>>

    @Query("SELECT * FROM entry_table WHERE id=:id")
    suspend fun getSingle(id: Int): Entry

    @Update
    suspend fun updateEntry(entry: Entry)

}
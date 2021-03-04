package com.naren.twbinding.data


import android.telecom.Call
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entry_table")
class Entry(
        @ColumnInfo(name = "entry_title")
        var title: String,

        @ColumnInfo(name = "entry_details")
        var details: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
package com.naren.twbinding.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = [Entry::class], version = 1)
abstract class EntryDatabase : RoomDatabase() {

    abstract fun entryDao(): EntryDAO

    companion object {
        @Volatile
        private var INSTANCE: EntryDatabase? = null

        fun buildDatabase(context: Context): EntryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context,
                        EntryDatabase::class.java,
                        "entry_database")
                        .build()
                INSTANCE = instance
                instance
            }
        }

    }
}
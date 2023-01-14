package com.minjae.highthon.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.minjae.highthon.data.local.dao.OmzDao
import com.minjae.highthon.data.local.entity.OmzEntity

@Database(
    entities = [
        OmzEntity::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters

abstract class OmzDatabase : RoomDatabase() {
    abstract fun omzDao(): OmzDao
}

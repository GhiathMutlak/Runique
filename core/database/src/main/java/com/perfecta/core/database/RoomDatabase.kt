package com.perfecta.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.perfecta.core.database.dao.RunDao
import com.perfecta.core.database.entities.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
}
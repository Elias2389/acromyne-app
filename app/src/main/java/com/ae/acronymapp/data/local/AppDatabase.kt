package com.ae.acronymapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ae.acronymapp.data.local.dao.MeaningResponseDao
import com.ae.acronymapp.data.local.entity.LongFormArrayTypeConverter
import com.ae.acronymapp.data.local.entity.MeaningResponseEntity

@Database(entities = [MeaningResponseEntity::class], version = 1)
@TypeConverters(LongFormArrayTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meaningDao(): MeaningResponseDao
}

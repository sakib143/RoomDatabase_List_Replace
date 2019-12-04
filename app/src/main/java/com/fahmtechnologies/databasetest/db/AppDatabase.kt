package com.fahmtechnologies.databasetest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fahmtechnologies.databasetest.db.converter.CityListConverter
import com.fahmtechnologies.databasetest.db.dao.CityListDao
import com.fahmtechnologies.databasetest.db.entity.CityList


const val CURRENT_USER_ID = 0

@Database(entities = [CityList::class], version = 1, exportSchema = false)

@TypeConverters(CityListConverter::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun cityListDao (): CityListDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "TempDatabase.db"
            ).build()
    }
}
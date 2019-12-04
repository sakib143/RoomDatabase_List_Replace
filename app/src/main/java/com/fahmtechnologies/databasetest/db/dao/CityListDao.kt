package com.fahmtechnologies.databasetest.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fahmtechnologies.databasetest.db.entity.CityList

@Dao
interface CityListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCity(cityModel: CityList)

    @Query("SELECT * FROM city_list")
    fun getAllCity() : CityList
}
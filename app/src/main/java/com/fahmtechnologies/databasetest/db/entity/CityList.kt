package com.fahmtechnologies.databasetest.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fahmtechnologies.databasetest.db.model.CityModel

@Entity(tableName = "city_list")
data class CityList (
    @PrimaryKey(autoGenerate = true) val id : Int? = null,
    val alCityList : List<CityModel>? = null)
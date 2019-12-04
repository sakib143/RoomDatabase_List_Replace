package com.fahmtechnologies.databasetest.db.converter

import androidx.room.TypeConverter
import com.fahmtechnologies.databasetest.db.model.CityModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CityListConverter {
    @TypeConverter
    fun fromCountryLangList(value: List<CityModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CityModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): List<CityModel> {
        val gson = Gson()
        val type = object : TypeToken<List<CityModel>>() {}.type
        return gson.fromJson(value, type)
    }
}
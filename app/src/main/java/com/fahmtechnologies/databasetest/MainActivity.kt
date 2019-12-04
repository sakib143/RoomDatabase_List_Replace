package com.fahmtechnologies.databasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fahmtechnologies.databasetest.db.AppDatabase
import com.fahmtechnologies.databasetest.db.CURRENT_USER_ID
import com.fahmtechnologies.databasetest.db.entity.CityList
import com.fahmtechnologies.databasetest.db.model.CityModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var database: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.invoke(this)

        GlobalScope.launch {
            val cityList = CityList(CURRENT_USER_ID, loadMultipleCity())
            database!!.cityListDao().insertAllCity(cityList)
            Log.e("=>"," City List size " + database!!.cityListDao().getAllCity().alCityList!!.size)

            val mList = CityList(CURRENT_USER_ID, loadOneCity())
            database!!.cityListDao().insertAllCity(mList)
            Log.e("=>"," City List size " + database!!.cityListDao().getAllCity().alCityList!!.size)
        }
    }

    fun loadMultipleCity() : List<CityModel>{
        var alMultipleCities: ArrayList<CityModel> = arrayListOf()
        alMultipleCities.add(CityModel("Mumbai"))
        alMultipleCities.add(CityModel("Pune"))
        alMultipleCities.add(CityModel("Surat"))
        return alMultipleCities
    }

    fun loadOneCity() : List<CityModel> {
        var alMultipleCities: ArrayList<CityModel> = arrayListOf()
        alMultipleCities.add(CityModel("Ahmedbad"))
        return alMultipleCities
    }

}

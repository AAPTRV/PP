package com.example.projectcountries.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projectcountries.room.converters.LanguagesV2Converter
import com.example.projectcountries.room.converters.LatLngConverter


@Database(
    entities = [CountryEntity::class],
    version = DBInfo.LATEST_VERSION
)
@TypeConverters(LanguagesV2Converter::class, LatLngConverter::class)
abstract class DBInfo: RoomDatabase() {

    abstract fun getCountryInfoDao(): CountryInfoDAO

    companion object{

        const val LATEST_VERSION = 6

        fun init(context: Context) =
            Room.databaseBuilder(context, DBInfo::class.java, "DB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}
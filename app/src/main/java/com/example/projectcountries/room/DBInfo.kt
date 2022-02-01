package com.example.projectcountries.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [CountryEntity::class],
    version = DBInfo.LATEST_VERSION
)

abstract class DBInfo: RoomDatabase() {

    abstract fun getCountryInfoDao(): CountryInfoDAO

    companion object{

        const val LATEST_VERSION = 3

        fun init(context: Context) =
            Room.databaseBuilder(context, DBInfo::class.java, "DB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}
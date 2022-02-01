package com.example.projectcountries.room

import androidx.room.*


@Dao
interface CountryInfoDAO {

    @Query("SELECT * FROM countries_data_base_table_info")
    fun getAllInfo(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAll(list: List<CountryEntity>)

    @Delete
    fun deleteAll(list: List<CountryEntity>)
}
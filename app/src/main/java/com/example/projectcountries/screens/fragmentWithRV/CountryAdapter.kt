package com.example.projectcountries.screens.fragmentWithRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcountries.R
import com.example.projectcountries.base.adapter.BaseAdapter
import com.example.projectcountries.dto.CountryDto
import com.example.projectcountries.dto.convertToString

class CountryAdapter  : BaseAdapter<CountryDto>(){

    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mCountryName = itemView.findViewById<TextView>(R.id.countryName)
        var mLanguageName = itemView.findViewById<TextView>(R.id.languageName)
        var mPopulation = itemView.findViewById<TextView>(R.id.population)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountriesViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CountriesViewHolder){
            val item = mDataListInAdapter[position]
            holder.mCountryName.text = item.name
//            holder.mLanguageName.text = item.languages.convertToString()
            holder.mPopulation.text = item.population.toString()
        }
    }
}
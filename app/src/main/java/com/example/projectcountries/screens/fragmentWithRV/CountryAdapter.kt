package com.example.projectcountries.screens.fragmentWithRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcountries.R
import com.example.projectcountries.base.adapter.BaseAdapter

class CountryAdapter  : BaseAdapter<String>(){

    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mCountryName = itemView.findViewById<TextView>(R.id.mainText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountriesViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CountriesViewHolder){
            val item = mDataListInAdapter[position]
            holder.mCountryName.text = item
        }
    }
}
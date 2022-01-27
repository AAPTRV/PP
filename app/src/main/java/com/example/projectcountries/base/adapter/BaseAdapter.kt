package com.example.projectcountries.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<ItemType>: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val mDataListInAdapter: MutableList<ItemType> = mutableListOf()

    protected var mOnItemClickListener: ((ItemType) -> Unit?)? = null

    override fun getItemCount(): Int = mDataListInAdapter.size

    interface OnItemClickListener<ItemType>{
        fun onClick(item: ItemType)
    }

    fun addListOfItems(list: MutableList<ItemType>){
        mDataListInAdapter.addAll(list)
        notifyDataSetChanged()
    }

    fun setItemClick(clickListener: (ItemType) -> Unit){
        mOnItemClickListener = clickListener
    }

    fun addItem(item: ItemType){
        mDataListInAdapter.add(item)
        notifyItemChanged(mDataListInAdapter.size - 1)
    }

}
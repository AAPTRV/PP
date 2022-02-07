package com.example.projectcountries.screens.fragmentWithRV

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcountries.R
import com.example.projectcountries.databinding.FragmentWithRVBinding
import com.example.projectcountries.model.CountryModel
import com.example.projectcountries.network.Retrofit
import com.example.projectcountries.room.CountryInfoDAO
import com.example.projectcountries.room.DBInfo
import com.example.projectcountries.transformer.CountryEntityTransformer.convertToDto
import com.example.projectcountries.transformer.CountryModelV2Transformer.convertToDto
import com.example.projectcountries.transformer.CountryModelV2Transformer.convertToEntity
import retrofit2.Call
import retrofit2.Response


class FragmentWithRW : Fragment() {

    private var binding: FragmentWithRVBinding? = null
    private var mCountryAdapter: CountryAdapter = CountryAdapter()
    private var mDatabase: DBInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWithRVBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ToolBar init
        binding?.appBar?.inflateMenu(R.menu.top_app_bar)
        binding?.appBar?.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.app_bar_search -> {
                    Toast.makeText(this.requireContext(), "OPTIONS TAPPED", Toast.LENGTH_LONG).show()
                    true
                }
                else -> { false }
            }
        }

        //RV init
        binding?.mainRecyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.mainRecyclerView?.setHasFixedSize(true)
        binding?.mainRecyclerView?.adapter = mCountryAdapter

        //DB init
        mDatabase = context?.let{ DBInfo.init(it)}
        val mDaoCountryInfo = mDatabase?.getCountryInfoDao()
        mDaoCountryInfo?.let {
            getDataFromRetrofit(it)
            getDataFromDB(it)
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun getDataFromRetrofit(countryDao: CountryInfoDAO){
        Retrofit.mRetrofitService.getPostsV2().enqueue(object : retrofit2.Callback<List<CountryModel>?> {
            override fun onFailure(call: Call<List<CountryModel>?>, t: Throwable) {
                Log.d(ContentValues.TAG, "On Failure: " + t.message)
            }

            override fun onResponse(
                call: Call<List<CountryModel>?>,
                response: Response<List<CountryModel>?>
            ) {
                response.body()?.let {
                    mCountryAdapter.addListOfItems(it.convertToDto())
                    countryDao.addAll(it.slice(0..20).convertToEntity())
                }
            }
        })
    }

    private fun getDataFromDB(countryDao: CountryInfoDAO){
        mCountryAdapter.addListOfItems(countryDao.getAllInfo().convertToDto().toMutableList())

    }
}
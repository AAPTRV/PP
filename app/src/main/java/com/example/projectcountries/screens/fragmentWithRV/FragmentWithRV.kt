package com.example.projectcountries.screens.fragmentWithRV

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcountries.R
import com.example.projectcountries.databinding.FragmentWithRVBinding
import com.example.projectcountries.dto.convertToDto
import com.example.projectcountries.model.CountryModelV2
import com.example.projectcountries.network.Retrofit
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentWithRW.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentWithRW : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentWithRVBinding? = null
    private var mCountryAdapter: CountryAdapter = CountryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
        binding?.mainRecyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.mainRecyclerView?.setHasFixedSize(true)
        binding?.mainRecyclerView?.adapter = mCountryAdapter
        getDataFromRetrofit()

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun fillListForExample(): List<String>{
        val data = mutableListOf<String>()
        (0..50).forEach { i -> data.add("Country #$i ...") }
        Log.e("LOG", "Data size is ${data.size}")
        return data
    }

    private fun getDataFromRetrofit(){
        Retrofit.mRetrofitService.getPostsV2().enqueue(object : retrofit2.Callback<List<CountryModelV2>?> {
            override fun onFailure(call: Call<List<CountryModelV2>?>, t: Throwable) {
                Log.d(ContentValues.TAG, "On Failure: " + t.message)
            }

            override fun onResponse(
                call: Call<List<CountryModelV2>?>,
                response: Response<List<CountryModelV2>?>
            ) {
                val responseBody = response.body() ?: emptyList()
                mCountryAdapter.addListOfItems(responseBody.convertToDto().toMutableList())

            }
        })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentWithRW().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
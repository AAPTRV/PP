package com.example.projectcountries.screens.startFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.projectcountries.R
import com.example.projectcountries.databinding.FragmentStartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null
    private val mImageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_the_Taliban.svg/320px-Flag_of_the_Taliban.svg.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragmentButton?.setOnClickListener {
            Toast.makeText(this.requireContext(), "BUTTON TAPPED", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.action_startFragment_to_fragmentWithRV)
        }
        binding?.mainImageView?.let {
            Glide.with(this.requireActivity())
                .load(mImageURL)
                .into(it)
        }

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}
package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.FragmentMainPageBinding
import com.ozger.foodieexpress.ui.adapter.FoodAdapter
import com.ozger.foodieexpress.ui.viewmodel.MainViewModel

class MainPageFragment : Fragment() {
    lateinit var binding: FragmentMainPageBinding
    lateinit var viewModel:MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_main_page,container,false)
        binding.rcylDetail.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.foodListVM.observe(viewLifecycleOwner){
            Log.d("hatam","foodListMain ${it.size.toString()}")
            val adapter=FoodAdapter(requireContext(),it)
            Log.d("hatam","foodListMain ${it.size.toString()}")

            binding.rcylDetail.adapter=adapter
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:MainViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.showFood()
    }


}
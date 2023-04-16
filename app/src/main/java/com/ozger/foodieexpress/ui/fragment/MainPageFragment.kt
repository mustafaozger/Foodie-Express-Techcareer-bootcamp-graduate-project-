package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.FragmentMainPageBinding
import com.ozger.foodieexpress.ui.adapter.FoodAdapter

class MainPageFragment : Fragment() {
    lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_main_page,container,false)
        val arrList=ArrayList<Foods>()
        var v1 =Foods(1,"df","ayran.png",312)
        var v2 =Foods(1,"df","ayran.png",312)
        var v3 =Foods(1,"df","ayran.png",312)
        var v4 =Foods(1,"df","ayran.png",312)

        arrList.add(v1)
        arrList.add(v2)
        arrList.add(v3)


        binding.rcylDetail.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter=FoodAdapter(requireContext(),arrList)
        binding.rcylDetail.adapter=adapter

        return binding.root
    }


}
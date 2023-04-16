package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.FragmentDetailFragmetnBinding
import com.ozger.foodieexpress.ui.adapter.FoodAdapter


class DetailFragmetn : Fragment() {

    lateinit var binding:FragmentDetailFragmetnBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_detail_fragmetn,container,false)


        return binding.root
    }


}
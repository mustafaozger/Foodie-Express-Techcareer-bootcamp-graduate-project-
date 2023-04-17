package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.FragmentDetailFragmetnBinding
import com.ozger.foodieexpress.ui.adapter.FoodAdapter


class DetailFragmetn : Fragment() {
    private var totalCount=1
    private var totalPrice=0
    lateinit var foodList:Foods
    lateinit var binding:FragmentDetailFragmetnBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_detail_fragmetn,container,false)
        val bundle:DetailFragmetnArgs by navArgs()
         foodList=bundle.foodList

        binding.btnAdd.setOnClickListener {
            add()
        }

        binding.btnMinus.setOnClickListener {
            minus()
        }

        return binding.root
    }
    fun add(){
        totalCount++
        binding.txtProductCount.text=totalCount.toString()
        calTotalPrice()
        if(totalCount==1){
            binding.buttonColor="#FFC80606"
        }
    }

    fun minus(){
        if(totalCount!=0){
            totalCount--
            binding.txtProductCount.text=totalCount.toString()
            calTotalPrice()
        }else{
            binding.buttonColor="#989393"
        }

    }

    fun calTotalPrice(){
        totalPrice=totalCount.toInt()*foodList.foodPrice
        binding.txtPrice.text=totalPrice.toString()
    }


}
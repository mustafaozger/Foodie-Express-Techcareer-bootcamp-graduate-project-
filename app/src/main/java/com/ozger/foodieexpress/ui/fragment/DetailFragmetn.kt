package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.FragmentDetailFragmetnBinding


class DetailFragmetn : Fragment() {
    private var totalCount=1
    private var totalPrice=0
    lateinit var food:Foods
    lateinit var binding:FragmentDetailFragmetnBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_detail_fragmetn,container,false)
        val bundle:DetailFragmetnArgs by navArgs()
         food=bundle.food
        binding.txtProductName.text=food.foodName

        binding.btnAdd.setOnClickListener {
            add()
        }

        binding.btnMinus.setOnClickListener {
            minus()
        }

        binding.btnAddCart.setOnClickListener {
            addCart(it)
        }

        return binding.root
    }
    fun add(){
        totalCount++
        binding.txtProductCount.text=totalCount.toString()
        calTotalPrice()

    }

    fun minus(){
        if(totalCount!=0){
            totalCount--
            binding.txtProductCount.text=totalCount.toString()
            calTotalPrice()
        }

    }

    fun calTotalPrice(){
        totalPrice=totalCount.toInt()*food.foodPrice
        binding.txtPrice.text=totalPrice.toString()
    }

    fun addCart(view: View){
        val transit=DetailFragmetnDirections.toCart()
        Navigation.findNavController(view).navigate(transit)

        //  TODO YAPILACAK
    }

}
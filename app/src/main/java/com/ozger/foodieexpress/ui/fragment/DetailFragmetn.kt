package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Cart
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.FragmentDetailFragmetnBinding
import com.ozger.foodieexpress.retrofit.Utils


class DetailFragmetn : Fragment() {
    private lateinit var imageURL :String
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
        binding.txtProductName.text=food.yemek_adi
        binding.txtPrice.text=food.yemek_fiyat.toString()
        imageURL="http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(requireContext()).load(imageURL).override(300,600).into(binding.imgProduct)

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
        totalPrice=totalCount.toInt()*food.yemek_fiyat
        binding.txtPrice.text=totalPrice.toString()
    }

    fun addCart(view: View){
        val addedFood=Cart(food.yemek_id,food.yemek_adi,food.yemek_resim_adi,food.yemek_fiyat,totalCount,"mustafaozger")
        Utils.cartList.add(addedFood)
        val transit=DetailFragmetnDirections.toCart()
        Navigation.findNavController(view).navigate(transit)

        //  TODO YAPILACAK
    }

}
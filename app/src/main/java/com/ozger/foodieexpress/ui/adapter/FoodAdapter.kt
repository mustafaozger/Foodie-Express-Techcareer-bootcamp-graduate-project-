package com.ozger.foodieexpress.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.databinding.RcylFoodMainBinding
import com.ozger.foodieexpress.ui.fragment.MainPageFragmentDirections

class FoodAdapter(var context:Context,var foodList:List<Foods>):RecyclerView.Adapter<FoodAdapter.FoodVH>() {
    inner class FoodVH(var binding: RcylFoodMainBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodVH {
        val binding:RcylFoodMainBinding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.rcyl_food_main,parent,false)
        return FoodVH(binding)
    }
    override fun getItemCount(): Int {
        return foodList.size    
    }

    override fun onBindViewHolder(holder: FoodVH, position: Int) {
        val food=foodList.get(position)
        val rcylItem=holder.binding

        val url="http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        rcylItem.rcylMainImageName.text=food.yemek_adi
        Glide.with(context).load(url).override(300,300).into(rcylItem.rcylMainImage)

        rcylItem.btnDetail.setOnClickListener {
            transition(it,food)
        }
    }
    fun transition(view: View,food:Foods){
        val transition=MainPageFragmentDirections.toDetail(food=food)
        Navigation.findNavController(view).navigate(transition)
    }
}
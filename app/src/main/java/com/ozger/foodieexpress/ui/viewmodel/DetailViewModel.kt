package com.ozger.foodieexpress.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ozger.foodieexpress.data.repo.FoodDaoRepository

class DetailViewModel:ViewModel() {
    val foodDao=FoodDaoRepository()

    fun addCart(name:String,imageName:String,price:Int,count:Int){
        foodDao.addCart(name,imageName,price,count)
    }
}
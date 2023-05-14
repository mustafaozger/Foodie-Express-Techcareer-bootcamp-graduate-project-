package com.ozger.foodieexpress.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozger.foodieexpress.data.entity.Cart
import com.ozger.foodieexpress.data.repo.FoodDaoRepository
import com.ozger.foodieexpress.retrofit.Utils

class CartViewModel:ViewModel() {

    val foodDao=FoodDaoRepository()
//
}
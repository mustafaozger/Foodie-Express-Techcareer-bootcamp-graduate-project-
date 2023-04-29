package com.ozger.foodieexpress.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.data.repo.FoodDaoRepository

class MainViewModel:ViewModel() {
    val foodRepo=FoodDaoRepository()
    val foodListVM:MutableLiveData<List<Foods>>

    init{
        showFood()
        foodListVM=foodRepo.takeFood()
    }

   fun showFood(){
        foodRepo.showFood()
    }
}
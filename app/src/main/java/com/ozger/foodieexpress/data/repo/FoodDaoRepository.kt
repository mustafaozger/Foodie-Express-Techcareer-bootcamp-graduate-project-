package com.ozger.foodieexpress.data.repo

import android.util.Log
import com.ozger.foodieexpress.data.entity.Foods
import com.ozger.foodieexpress.retrofit.FoodDao
import androidx.lifecycle.MutableLiveData
import com.ozger.foodieexpress.data.entity.CRUDRespond
import com.ozger.foodieexpress.data.entity.FoodRespond
import com.ozger.foodieexpress.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects


class FoodDaoRepository {
    var foodList:MutableLiveData<List<Foods>>
    var foodDao:FoodDao

    init {
        foodList = MutableLiveData()
        foodDao = ApiUtils.getFoodDao()
    }
    fun takeFood():MutableLiveData<List<Foods>>{
        return foodList
    }

    fun showFood(){
        foodDao.getAllFood().enqueue(object :Callback<FoodRespond>{
            override fun onResponse(call: Call<FoodRespond>, response: Response<FoodRespond>) {


            }

            override fun onFailure(call: Call<FoodRespond>, t: Throwable) {
            }

        })
    }


    fun addCart(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int){
        foodDao.addCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet,"mustafa_ozger").enqueue(object : Callback<CRUDRespond>{
            override fun onResponse(call: Call<CRUDRespond>, response: Response<CRUDRespond>) {

            }override fun onFailure(call: Call<CRUDRespond>, t: Throwable) {}
        })
    }
}
package com.ozger.foodieexpress.retrofit

class ApiUtils {
    companion object{
        //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php
        val BASE_URL="http://kasimadalan.pe.hu"
        fun getFoodDao():FoodDao{
            return RetrofitClient.getClient(BASE_URL).create(FoodDao::class.java)
        }
    }
}
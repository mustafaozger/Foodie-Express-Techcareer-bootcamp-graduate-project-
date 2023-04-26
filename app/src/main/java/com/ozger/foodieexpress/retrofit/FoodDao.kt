package com.ozger.foodieexpress.retrofit

import com.ozger.foodieexpress.data.entity.CRUDRespond
import com.ozger.foodieexpress.data.entity.CartRespond
import com.ozger.foodieexpress.data.entity.FoodRespond
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {
    @GET("yemekler/tumYemekleriGetir.php")
    fun getAllFood():Call<FoodRespond>


    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun getFromCart(@Field("kullanici_adi") kullanici_adi:String):Call<CartRespond>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun addCart(@Field("yemek_adi") yemek_adi:String,
                @Field("yemek_resim_adi") yemek_resim_adi:String,
                @Field("yemek_fiyat") yemek_fiyat:Int,
                @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                @Field("kullanici_adi") kullanici_adi:String
                ):Call<CRUDRespond>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteFoodFromCart(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                            @Field("kullanici_adi") kullanici_adi:String):Call<CRUDRespond>


}
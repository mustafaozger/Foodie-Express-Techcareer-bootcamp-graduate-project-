package com.ozger.foodieexpress.data.entity

data class Cart(var sepet_yemek_id:Int,
           var yemek_adi:String,
           var yemek_resim_adi:String,
           var yemek_fiyat:Int,
           var yemek_siparis_adet:Int,
           var kullanici_adi:String){
}
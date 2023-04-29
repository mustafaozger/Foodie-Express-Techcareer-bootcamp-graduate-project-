package com.ozger.foodieexpress.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.data.entity.Cart
import com.ozger.foodieexpress.databinding.RcylCartBinding
import com.ozger.foodieexpress.retrofit.Utils

data class CartAdapter(val context: Context,val list :ArrayList<Cart>):
    RecyclerView.Adapter<CartAdapter.CartAdapterVH>() {
    inner class CartAdapterVH(var binding:RcylCartBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapterVH {
        val binding:RcylCartBinding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.rcyl_cart,parent,false)
        return CartAdapterVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CartAdapterVH, position: Int) {
        val cart=list.get(position)
        val rcyItem=holder.binding


        val url="http://kasimadalan.pe.hu/yemekler/resimler/${cart.yemek_resim_adi}"
        Glide.with(context).load(url).override(300,300).into(rcyItem.imgProductMage)

        rcyItem.txtProductName.text=cart.yemek_adi
        rcyItem.txtProductCount.text=cart.yemek_siparis_adet.toString()
        rcyItem.txtCartPrice.text=("${cart.yemek_fiyat * rcyItem.txtProductCount.text.toString().toInt()}")

        rcyItem.btnAdd.setOnClickListener {
            rcyItem.txtProductCount.text="${cart.yemek_siparis_adet+1} "
            cart.yemek_siparis_adet+=1
            rcyItem.txtCartPrice.text=("${cart.yemek_fiyat * Utils.cartList.get(position).yemek_siparis_adet}")

        }
        rcyItem.btnMinus.setOnClickListener {
            if (cart.yemek_siparis_adet>=1){
                rcyItem.txtProductCount.text="${cart.yemek_siparis_adet-1} "
                cart.yemek_siparis_adet-=1
                rcyItem.txtCartPrice.text=("${cart.yemek_fiyat * Utils.cartList.get(position).yemek_siparis_adet}")
            }
        }

        rcyItem.imgRemove.setOnClickListener {
            Utils.cartList.remove(cart)
        }


    }






}
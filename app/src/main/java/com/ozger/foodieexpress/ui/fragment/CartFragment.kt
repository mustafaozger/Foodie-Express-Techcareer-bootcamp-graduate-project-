package com.ozger.foodieexpress.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozger.foodieexpress.R
import com.ozger.foodieexpress.databinding.FragmentCartBinding
import com.ozger.foodieexpress.retrofit.Utils
import com.ozger.foodieexpress.ui.adapter.CartAdapter


class CartFragment : Fragment() {
    lateinit var binding:FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_cart,container,false)
        binding.rcylCart.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)

        val adapter=CartAdapter(requireContext(),Utils.cartList)
        binding.rcylCart.adapter=adapter



        return binding.root
    }

}
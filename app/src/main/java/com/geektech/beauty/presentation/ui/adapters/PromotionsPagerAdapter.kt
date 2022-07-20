package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemPlaceHolderPromotionBinding
import com.geektech.beauty.presentation.models.PromotionsUI

class PromotionsPagerAdapter(private val banners: ArrayList<PromotionsUI>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemPlaceHolderPromotionBinding.inflate(
            LayoutInflater.from(container.context),
            container,
            false
        )
        binding.imageItemPromotion.loadImageWithGlide(banners[position].data)

        container.addView(binding.root)

        return binding.root
    }

    override fun getCount(): Int {
        return banners.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

}
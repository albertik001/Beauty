package com.geektech.beauty.presentation.ui.fragments.main.home.salon

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.PromotionsUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SalonViewModel @Inject constructor() : BaseViewModel() {

    fun setLocalData(): ArrayList<PromotionsUI> {
        val listPromotions = ArrayList<PromotionsUI>()
        for (i in 1..3) {
            listPromotions.add(PromotionsUI("https://newstyle-mag.com/wp-content/uploads/2020/05/beauty_salon-_9_.jpg"))
        }
        return listPromotions
    }

}
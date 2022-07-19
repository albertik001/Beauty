package com.geektech.beauty.presentation.ui.fragments.main.home.salon

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.ButtonServicesUI
import com.geektech.beauty.presentation.models.PromotionsUI
import com.geektech.beauty.presentation.models.SalonInformationUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SalonViewModel @Inject constructor() : BaseViewModel() {

    fun getPromotionBanners(): ArrayList<PromotionsUI> {
        val listPromotions = ArrayList<PromotionsUI>()
        for (i in 1..3) {
            listPromotions.add(PromotionsUI("https://newstyle-mag.com/wp-content/uploads/2020/05/beauty_salon-_9_.jpg"))
        }
        return listPromotions
    }

    fun getSalonInfo(): SalonInformationUI {
        return SalonInformationUI(
            "8:00-24:00",
            "24/7, без выходных",
            "ул. Кулиева 152/1",
            "+996 555 666999",
            "vi-bish@gmail.com"
        )
    }

    fun getButtonServices(): ArrayList<ButtonServicesUI> {
        val listBtnServices = ArrayList<ButtonServicesUI>()
        for (i in 1..10) {
            listBtnServices.add(ButtonServicesUI("Парикмахер"))
            listBtnServices.add(ButtonServicesUI("Шлюха"))
            listBtnServices.add(ButtonServicesUI("Ногтевой мастер"))
            listBtnServices.add(ButtonServicesUI("Парикмахер"))
            listBtnServices.add(ButtonServicesUI("Шлюха"))
            listBtnServices.add(ButtonServicesUI("Ногтевой мастер"))
        }
        return listBtnServices
    }

}
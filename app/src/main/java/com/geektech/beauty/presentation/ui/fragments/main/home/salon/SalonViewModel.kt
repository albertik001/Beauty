package com.geektech.beauty.presentation.ui.fragments.main.home.salon

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SalonViewModel @Inject constructor() : BaseViewModel() {

    private val _customersFeedbacksState = MutableStateFlow<List<CustomerFeedbackUI>>(emptyList())
    val customersFeedbacksState = _customersFeedbacksState.asStateFlow()

    fun getPromotionBanners(): ArrayList<PromotionsUI> {
        val listPromotions = ArrayList<PromotionsUI>()
        for (i in 1..3) {
            listPromotions.add(PromotionsUI("https://newstyle-mag.com/wp-content/uploads/2020/05/beauty_salon-_9_.jpg"))
        }
        return listPromotions
    }

    private fun fetchFeedbacks() {
        var list = listOf(
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Кристина Ким",
                "Приятная отмосфера, обслуживание класса люкс, специалисты своего дела!", 3.5
            )
        )
        for (i in 1..20) {
            list = listOf(
                CustomerFeedbackUI(
                    "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                    "Кристина Ким",
                    "Приятная отмосфера, обслуживание класса люкс, специалисты своего дела!", 3.5
                )
            )
        }
        _customersFeedbacksState.value = list
    }

    fun getSalonInfo(): SalonInformationUI {
        return SalonInformationUI(
            "8:00-24:00",
            "24/7, без выходных",
            "ул. Ибраимова 152/1",
            "+996 555 666999",
            "vi-bish@gmail.com"
        )
    }

    fun getButtonServices(): ArrayList<ButtonServicesUI> {
        val listBtnServices = ArrayList<ButtonServicesUI>()
        for (i in 1..10) {
            listBtnServices.add(ButtonServicesUI("Парикмахер"))
            listBtnServices.add(ButtonServicesUI("Барбер"))
            listBtnServices.add(ButtonServicesUI("Ногтевой мастер"))
            listBtnServices.add(ButtonServicesUI("Парикмахер"))
            listBtnServices.add(ButtonServicesUI("Барбер"))
            listBtnServices.add(ButtonServicesUI("Ногтевой мастер"))
        }
        return listBtnServices
    }

    fun getTopSpecialist(): ArrayList<TopSpecialistUI> {
        val listTopSpecialist = arrayListOf<TopSpecialistUI>()
        for (i in 1..12) {
            listTopSpecialist.add(
                TopSpecialistUI(
                    "https://n1s1.hsmedia.ru/bf/93/4e/bf934eadd2b3ca9bbf983dedfa46198b/728x485_1_51d766d325aa86e6c23de6da39badc03@2121x1414_0xac120003_3094744421586782369.jpg",
                    "Алина-мастер"
                )
            )
        }
        return listTopSpecialist
    }

    fun getSalonInterior(): ArrayList<InteriorUI> {
        val listSalonInterior = arrayListOf<InteriorUI>()
        for (i in 1..10) {
            listSalonInterior.add(InteriorUI("https://media.admagazine.ru/photos/6221e2a66c8dba98f241fa9b/4:3/w_1600%2Cc_limit/%25D1%2581%25D0%25B5%25D0%25BB%25D1%258C%25D1%2581%25D0%25BA%25D0%25BE%25D1%2585%25D0%25BE%25D0%25B7.%2520%2520web%2520(7%2520of%252053).jpg"))
        }
        return listSalonInterior
    }

    fun getOurSpecialistWork(): ArrayList<OurSpecialistWorkUI> {
        val listOurSpecialistWork = arrayListOf<OurSpecialistWorkUI>()
        for (i in 1..10) {
            listOurSpecialistWork.add(OurSpecialistWorkUI("https://namillion.com/wp-content/uploads/2017/09/zarplata-2-1.jpg"))
        }
        return listOurSpecialistWork
    }

    init {
        fetchFeedbacks()
    }

}
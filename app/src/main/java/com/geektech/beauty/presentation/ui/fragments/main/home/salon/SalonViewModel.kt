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
        val list = listOf(
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 5.0

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 3.5

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 2.3

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 1.0

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 1.2

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 5.0

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 3.5

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 2.3

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 1.0

            ),
            CustomerFeedbackUI(
                "https://www.moshimoshi-nippon.jp/wp/wp-content/uploads/2020/06/a35d15c36fc7cc1cd02cd670b4c30cd5-1.jpg",
                "Аня,500м от вас",
                "Кунилингус неплох, anal fisting тоже на уровне", 1.2

            ),
        )
        _customersFeedbacksState.value = list
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

    fun getTopSpecialist(): ArrayList<TopSpecialistUI> {
        val listTopSpecialist = arrayListOf<TopSpecialistUI>()
        for (i in 1..12) {
            listTopSpecialist.add(
                TopSpecialistUI(
                    "https://icdn.lenta.ru/images/2013/09/20/16/20130920163740742/detail_b8aab4cfd27d9fa1ef3235fa046e7700.jpg",
                    "Шыпаргуль-мастер инвидуал"
                )
            )
        }
        return listTopSpecialist
    }

    fun getSalonInterior(): ArrayList<InteriorUI> {
        val listSalonInterior = arrayListOf<InteriorUI>()
        for (i in 1..10) {
            listSalonInterior.add(InteriorUI("https://upload.wikimedia.org/wikipedia/commons/8/89/Jaguar_X300_interior_%281995%2C_Warm_charcoal_%26_Cream%29.jpg"))
        }
        return listSalonInterior
    }

    fun getOurSpecialistWork(): ArrayList<OurSpecialistWorkUI> {
        val listOurSpecialistWork = arrayListOf<OurSpecialistWorkUI>()
        for (i in 1..10) {
            listOurSpecialistWork.add(OurSpecialistWorkUI("https://n1s2.starhit.ru/12/a2/f1/12a2f129636048a79f48009e07500636/444x460_0_05197487bc0706d7560da0de61000a39@480x497_0xac120003_18487509071595265174.jpg"))
        }
        return listOurSpecialistWork
    }

    init {
        fetchFeedbacks()
    }

}
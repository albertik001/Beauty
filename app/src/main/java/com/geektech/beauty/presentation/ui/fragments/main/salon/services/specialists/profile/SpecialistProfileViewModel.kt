package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.profile

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.CustomerFeedbackUI
import com.geektech.beauty.presentation.models.SpecialistServiceUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SpecialistProfileViewModel @Inject constructor() : BaseViewModel() {
    private val _specialistServicesState = MutableStateFlow<List<SpecialistServiceUI>>(emptyList())
    val specialistServicesState = _specialistServicesState.asStateFlow()

    private val _customersFeedbacksState = MutableStateFlow<List<CustomerFeedbackUI>>(emptyList())
    val customersFeedbacksState = _customersFeedbacksState.asStateFlow()

    private fun fetchSpecialistServices() {
        val list = listOf(
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
            SpecialistServiceUI("Классика", 100, 1),
        )
        _specialistServicesState.value = list
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

    init {
        fetchSpecialistServices()
        fetchFeedbacks()
    }
}
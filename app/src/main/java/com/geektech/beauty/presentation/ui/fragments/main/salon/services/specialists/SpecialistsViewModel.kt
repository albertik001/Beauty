package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.ServiceCategorySpecialistUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SpecialistsViewModel @Inject constructor() : BaseViewModel() {
    private val _specialistsState = MutableStateFlow<List<ServiceCategorySpecialistUI>>(emptyList())
    val specialistsState = _specialistsState.asStateFlow()
    private fun fetchSpecialists() {
        val list = listOf(
            ServiceCategorySpecialistUI(
                "Парикмахер",
                "https://res.heraldm.com/content/image/2021/04/12/20210412000524_0.jpg",
                "Айжан-мастер индивидуал.",
                25,
                4.0
            ),
            ServiceCategorySpecialistUI(
                "Парикмахер",
                "https://res.heraldm.com/content/image/2021/04/12/20210412000524_0.jpg",
                "Шыпыргуль-мастер индивидуал.",
                25,
                3.5
            ),
            ServiceCategorySpecialistUI(
                "Парикмахер",
                "https://res.heraldm.com/content/image/2021/04/12/20210412000524_0.jpg",
                "Шыпыргуль-мастер индивидуал.",
                25,
                2.1
            ),
            ServiceCategorySpecialistUI(
                "Парикмахер",
                "https://res.heraldm.com/content/image/2021/04/12/20210412000524_0.jpg",
                "Шыпыргуль-мастер индивидуал.",
                25,
                1.9
            ),
        )
        _specialistsState.value = list
    }

    init {
        fetchSpecialists()
    }
}
package com.geektech.beauty.presentation.ui.fragments.main.salon.services

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.DetailedCategoryUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailedServicesCategoryViewModel @Inject constructor() : BaseViewModel() {
    private val _detailedServicesState = MutableStateFlow<List<DetailedCategoryUI>>(emptyList())
    val detailedServicesState = _detailedServicesState.asStateFlow()

    private fun fetchDetailedServices() {
        val list = listOf(
            DetailedCategoryUI(
                "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                "Стрижка",
                "1 час",
                "666 сом"
            ),
            DetailedCategoryUI(
                "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                "Стрижка",
                "1 час",
                "666 сом"
            ),
            DetailedCategoryUI(
                "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                "Стрижка",
                "1 час",
                "666 сом"
            ),
            DetailedCategoryUI(
                "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                "Стрижка",
                "1 час",
                "666 сом"
            ),
            DetailedCategoryUI(
                "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                "Стрижка",
                "1 час",
                "666 сом"
            ),
        )

        _detailedServicesState.value = list
    }

    init {
        fetchDetailedServices()
    }
}

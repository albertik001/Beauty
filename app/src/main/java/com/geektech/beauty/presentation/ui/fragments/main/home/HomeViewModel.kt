package com.geektech.beauty.presentation.ui.fragments.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.CategoryUI
import com.geektech.beauty.presentation.models.PopularUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _categoryState = MutableLiveData<List<CategoryUI>>()
    val categoryState: LiveData<List<CategoryUI>> = _categoryState

    private val _popularState = MutableLiveData<List<PopularUI>>()
    val popularState: LiveData<List<PopularUI>> = _popularState


    private fun setLocalData() {
        val listCategory = ArrayList<CategoryUI>()
        val listPopular = ArrayList<PopularUI>()
        for (i in 1..20) {
            listCategory.add(
                CategoryUI(
                    "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                    "Услуги парикмахера"
                )
            )
            listPopular.add(
                PopularUI(
                    "https://i.pinimg.com/736x/eb/0f/a5/eb0fa5f632b98d7aa961f880feca1a0a.jpg",
                    "Ногтевой сервис",
                    "BeStyle",
                    5
                )
            )
        }
        _categoryState.value = listCategory
        _popularState.value = listPopular
    }


    init {
        setLocalData()
    }
}
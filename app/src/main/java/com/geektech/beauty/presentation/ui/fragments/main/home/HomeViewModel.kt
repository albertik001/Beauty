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


    private fun setLocalData() {
        val list = ArrayList<CategoryUI>()
        _categoryState.value = list
        for (i in 1..20)
            list.add(
                CategoryUI(
                    "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                    "Услуги парикмахера"
                )
            )
        _categoryState.value = list

        val listPopular = ArrayList<PopularUI>()


    }

    init {
        setLocalData()
    }
}
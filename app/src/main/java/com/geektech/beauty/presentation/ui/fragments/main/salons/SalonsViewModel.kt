package com.geektech.beauty.presentation.ui.fragments.main.salons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.SalonsUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SalonsViewModel @Inject constructor() : BaseViewModel() {

    private val _salonsState = MutableLiveData<List<SalonsUI>>()
    val salonsState: LiveData<List<SalonsUI>> = _salonsState

    private fun setLocalData() {
        val listSalons = ArrayList<SalonsUI>()
        for (i in 1..20) {
            listSalons.add(
                SalonsUI(
                    "https://static.onecms.io/wp-content/uploads/sites/23/2022/04/25/hair-wrapping-2000.jpg",
                    "BeStyle",
                    3,
                    arrayListOf(
                        "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHx8&w=1000&q=80",
                        "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__480.jpg",
                        "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHx8&w=1000&q=80",
                        "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__480.jpg",
                        "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHx8&w=1000&q=80",
                        "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__480.jpg",
                        "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHx8&w=1000&q=80",
                        "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__480.jpg"
                    )
                )
            )
        }
        _salonsState.value = listSalons
    }


    init {
        setLocalData()
    }
}
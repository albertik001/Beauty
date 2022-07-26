package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.appointment

import com.geektech.beauty.core.base.BaseViewModel
import com.geektech.beauty.presentation.models.AppointmentDetailsUI
import com.geektech.beauty.presentation.models.SalonInformationUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppointmentsViewModel : BaseViewModel() {

    private val _appointmentsState =
        MutableStateFlow<List<AppointmentDetailsUI>>(emptyList())
    val appointmentsState = _appointmentsState.asStateFlow()

    private fun fetchDetailAppointment() {
        val list = listOf(
            AppointmentDetailsUI(
                "3 марта",
                "Утро 9:45",
                "Стрижка",
                "45 мин",
                "Айгул",
                "2000 сом",
                SalonInformationUI(
                    "8:00-24:00",
                    "24/7, без выходных",
                    "ул. Кулиева 152/1",
                    "+996 555 666999",
                    "vi-bish@gmail.com"
                )
            ),

            AppointmentDetailsUI(
                "4 марта",
                "День 14:25",
                "Маникюр-шеллак",
                "20 мин",
                "Шыпаргуль",
                "4000 сом",
                SalonInformationUI(
                    "7:00-23:00",
                    "24/7, без выходных",
                    "ул. Ибраимова 103",
                    "+996 707 770999",
                    "vi-bish@gmail.com"
                )
            ),
            AppointmentDetailsUI(
                "5 марта",
                "Вечер 19:00",
                "Шеллак",
                "15 мин",
                "Тимур",
                "3000 сом",
                SalonInformationUI(
                    "09:00-22:00",
                    "24/7, без выходных",
                    "ул. Уметалиева 77/1",
                    "+996 555 666333",
                    "vi-bish@gmail.com"
                )
            ),
            AppointmentDetailsUI(
                "6 марта",
                "Ночь 2:40",
                "Укладка",
                "30 мин",
                "Альберт",
                "7000 сом",
                SalonInformationUI(
                    "10:00-24:00",
                    "24/7, без выходных",
                    "ул. Айтматова 90/1",
                    "+996 555 5555555",
                    "vi-bish@gmail.com"
                )
            ),
            AppointmentDetailsUI(
                "7 марта",
                "Утро 6:25",
                "Ламинирование",
                "20 мин",
                "Айдана",
                "2990 сом",
                SalonInformationUI(
                    "09:00-22:00",
                    "24/7, без выходных",
                    "ул. Уметалиева 77/1",
                    "+996 555 666333",
                    "vi-bish@gmail.com"
                )
            )
        )
        _appointmentsState.value = list
    }

    init {
        fetchDetailAppointment()
    }
}
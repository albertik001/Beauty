package com.geektech.beauty.presentation.models

data class AppointmentDetailsUI(
    val dateOfAppointments: String,
    val timeOfWork: String,
    val service: String,
    val duration: String,
    val specialist: String,
    val serviceCost: String,
    val salonInformationUI: SalonInformationUI
) {

}
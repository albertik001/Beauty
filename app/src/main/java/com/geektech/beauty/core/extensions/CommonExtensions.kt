package com.geektech.beauty.core.extensions

import java.text.SimpleDateFormat
import java.util.*

fun formatCurrentUserTime(dateFormat: String): String =
    SimpleDateFormat(dateFormat, Locale.getDefault()).format(Date())


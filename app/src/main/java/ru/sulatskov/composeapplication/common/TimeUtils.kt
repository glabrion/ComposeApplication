package ru.sulatskov.composeapplication.common

import android.content.Context
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

class TimeUtils() {

    fun getDateWithTimeFirst(context: Context, seconds: Long): String {
        val date= Date(seconds * 1000L)
        val simpleTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        return DateUtils.formatDateTime(
            context, seconds,
            DateUtils.FORMAT_SHOW_YEAR
        ) + ", " + simpleTimeFormat.format(date)
    }
}

package ru.sulatskov.composeapplication.common

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

fun getDate(context: Context, date: String): String {
    var resultDate = date
    try {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        val tempDate: Date = simpleDateFormat.parse(date)
        val timeUtils = TimeUtils()
        resultDate = timeUtils.getDateWithTimeFirst(context, tempDate.time)

    } catch (e: Exception) {
        e.printStackTrace()
    }
    return resultDate
}
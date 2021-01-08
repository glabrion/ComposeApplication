package ru.sulatskov.composeapplication.common

import android.content.Context
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import java.text.SimpleDateFormat
import java.util.*

fun Modifier.visible(visibility: Boolean): Modifier {
    return if (visibility) {
        this.then(alpha(1f))
    } else {
        this.then(alpha(0f))
    }
}

fun getDate(context: Context, date: String): String {
    var resultDate = date
    try {
        val date_s = date
        val simpledateformat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        val tempDate: Date = simpledateformat.parse(date_s)
        tempDate.time
        val timeUtils = TimeUtils(context)
        val outputDateFormat = SimpleDateFormat("yyyy-MM-dd")
        resultDate = timeUtils.getDateWithInTime(context, tempDate.time)

    } catch (e: Exception) {
        e.printStackTrace()

    }
    return resultDate
}
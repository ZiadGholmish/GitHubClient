package com.scalablecapitaltask.utils

import android.net.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by ziadgholmish on 3/2/18.
 */
class GithubDateUtils {

    companion object {

        private val GITHUB_DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss"
        private val DATE_FORMAT_PATTERN = "EEE, d MMM yyyy"

        fun getFormattedDate(date: String): String {
            val dateFormat = SimpleDateFormat(GITHUB_DATE_FORMAT_PATTERN, Locale.US)
            var convertedDate = Date()
            try {
                convertedDate = dateFormat.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return formatDateToMonthYear(convertedDate)
        }

        private fun formatDateToMonthYear(convertedDate: Date): String {
            return SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.US).format(convertedDate)
        }
    }
}
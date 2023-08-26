package com.stevdza.san.androidapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.lang.Exception
import java.text.DateFormat
import java.util.Date

fun String.decodeThumbnailImage(): Bitmap? {
    return try {
        val byteArray = Base64.decode(this.cleanupImageString(), Base64.NO_WRAP)
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    } catch (e: Exception) {
        null
    }
}

fun String.cleanupImageString(): String {
    return this.replace("data:image/png;base64,", "")
        .replace("data:image/jpeg;base64,", "")
}

fun Long.convertLongToDate(): String {
    return DateFormat.getDateInstance().format(Date(this))
}
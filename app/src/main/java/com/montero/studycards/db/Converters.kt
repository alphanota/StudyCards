package com.montero.studycards.db

import androidx.room.TypeConverter
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    companion object {

        @TypeConverter
        @JvmStatic
        fun fromUUID(value: UUID) : String {
            return value.toString()
        }

        @TypeConverter
        @JvmStatic
        fun toUUID(value: String) : UUID {
            return UUID.fromString(value)
        }


    }
}
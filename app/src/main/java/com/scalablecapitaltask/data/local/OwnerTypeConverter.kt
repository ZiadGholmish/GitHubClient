package com.scalablecapitaltask.data.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scalablecapitaltask.data.models.Owner

import java.util.*

/**
 * Created by ziadgholmish on 3/1/18.
 */
class OwnerTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToOwner(data: String?): Owner {
        val ownerType = object : TypeToken<Owner>() {}.type
        return gson.fromJson(data, ownerType)
    }

    @TypeConverter
    fun ownerToString(owner: Owner): String {
        return gson.toJson(owner)
    }
}
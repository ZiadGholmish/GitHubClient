package com.scalablecapitaltask.data.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scalablecapitaltask.data.models.OwnerEntity

/**
 * Created by ziadgholmish on 3/1/18.
 */
class OwnerTypeConverter {

    private val gson = Gson()

    /**
     * convert the string come from the database to owner object so later i can use it
     */
    @TypeConverter
    fun stringToOwner(data: String?): OwnerEntity {
        val ownerType = object : TypeToken<OwnerEntity>() {}.type
        return gson.fromJson(data, ownerType)
    }

    /**
     * convert the owner object to string so i can save it in room database without create another
     * table in the database
     */
    @TypeConverter
    fun ownerToString(owner: OwnerEntity): String {
        return gson.toJson(owner)
    }
}
package com.example.roombase.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson

/**
 * Room converters
 */
class Converters {

    /**
     * Type converter for some object to json
     *
     * @param obj Object, replace for specific object
     *
     * @return json
     */
    @TypeConverter
    fun objectToJson(obj: Any?): String? = Gson().toJson(obj)

    @TypeConverter
    fun objectFromJson(str: String): Any = Gson().fromJson(str, Any::class.java)

}
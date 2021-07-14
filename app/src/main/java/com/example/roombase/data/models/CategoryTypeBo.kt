package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.CategoryTypeEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryTypeBo(
    var categoryTypeId: Long,
    var name: String,
    var description: String = ""
) : Parcelable, BaseBo<CategoryTypeEntity> {
    override fun toEntity(): CategoryTypeEntity {
        return CategoryTypeEntity(
            categoryTypeId = categoryTypeId,
            name = name,
            description = description
        )
    }
}
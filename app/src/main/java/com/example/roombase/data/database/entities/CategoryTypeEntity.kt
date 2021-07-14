package com.example.roombase.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roombase.data.models.CategoryTypeBo
import com.example.roombase.utils.TABLE_CATEGORY_TYPE
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_CATEGORY_TYPE)
class CategoryTypeEntity(
    @SerializedName("categoryTypeId") @PrimaryKey(autoGenerate = true) var categoryTypeId: Long = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("description") var description: String = ""
) : BaseEntity<CategoryTypeBo> {
    override fun toBo(): CategoryTypeBo {
        return CategoryTypeBo(
            categoryTypeId = categoryTypeId,
            name = name,
            description = description
        )
    }
}
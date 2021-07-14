package com.example.roombase.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roombase.data.models.CategoryBo
import com.example.roombase.utils.TABLE_CATEGORY
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_CATEGORY)
class CategoryEntity(
    @SerializedName("categoryId") @PrimaryKey(autoGenerate = true) var categoryId: Long = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("image") var image: String = "",
    @SerializedName("showOrder") var showOrder: Int = 0,
    @SerializedName("isVisibleInApp") var isVisibleInApp: Boolean,
    @SerializedName("categoryTypeId") var categoryTypeId: String,
) : BaseEntity<CategoryBo> {
    override fun toBo(): CategoryBo {
        return CategoryBo(
            categoryId = categoryId,
            name = name,
            image = image,
            showOrder = showOrder,
            isVisibleInApp = isVisibleInApp,
            categoryTypeId = categoryTypeId,
        )
    }
}
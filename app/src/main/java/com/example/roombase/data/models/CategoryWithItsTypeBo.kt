package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.CategoryEntity
import com.example.roombase.data.database.entities.CategoryWithItsTypeEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryWithItsTypeBo(
    var categoryTypeBo: CategoryTypeBo,
    var categoriesBo: List<CategoryBo>,
) : Parcelable, BaseBo<CategoryWithItsTypeEntity> {
    override fun toEntity(): CategoryWithItsTypeEntity {
        return CategoryWithItsTypeEntity(
            categoryTypeEntity = categoryTypeBo.toEntity(),
            categoriesEntity = categoriesToEntity(categoriesBo)
        )
    }

    private fun categoriesToEntity(categoriesBo: List<CategoryBo>): List<CategoryEntity> {

        val list: MutableList<CategoryEntity> = mutableListOf()

        categoriesBo.map { list.add(it.toEntity()) }

        return list
    }
}
package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.roombase.data.models.CategoryBo
import com.example.roombase.data.models.CategoryWithItsTypeBo

//@Entity(tableName = TABLE_CATEGORY_WITH_ITS_TYPE)
class CategoryWithItsTypeEntity(
    @Embedded var categoryTypeEntity: CategoryTypeEntity,
    @Relation(
        parentColumn = "categoryTypeId",
        entityColumn = "categoryTypeId"
    )
    var categoriesEntity: List<CategoryEntity>,

    ) : BaseEntity<CategoryWithItsTypeBo> {
    override fun toBo(): CategoryWithItsTypeBo {
        return CategoryWithItsTypeBo(
            categoryTypeBo = categoryTypeEntity.toBo(),
            categoriesBo = categoriesToBo(categoriesEntity.toList())
        )
    }

    private fun categoriesToBo(categoriesEntity: List<CategoryEntity>): List<CategoryBo> {

        val list: MutableList<CategoryBo> = mutableListOf()

        categoriesEntity.map { list.add(it.toBo()) }

        return list
    }
}
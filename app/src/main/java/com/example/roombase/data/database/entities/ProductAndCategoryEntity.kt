package com.example.roombase.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.roombase.data.models.ProductAndCategoryBo
import com.example.roombase.utils.TABLE_PRODUCT_AND_CATEGORY

@Entity(tableName = TABLE_PRODUCT_AND_CATEGORY)
class ProductAndCategoryEntity(
    @Embedded var productEntity: ProductEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    var categoryEntity: CategoryEntity,
) :BaseEntity <ProductAndCategoryBo>{
    override fun toBo(): ProductAndCategoryBo {
       return ProductAndCategoryBo(
           productBo= productEntity.toBo(),
           categoryBo = categoryEntity.toBo(),
       )
    }
}
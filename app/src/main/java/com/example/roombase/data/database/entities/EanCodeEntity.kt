package com.example.roombase.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roombase.data.models.EanCodeBo
import com.example.roombase.utils.TABLE_EAN_CODE

@Entity(tableName = TABLE_EAN_CODE)
class EanCodeEntity(
    @PrimaryKey var eanCode: String = "",
    var productId : Long = 0
) : BaseEntity<EanCodeBo>{
    override fun toBo(): EanCodeBo {
        return EanCodeBo(
            eanCode = eanCode,
            productId = productId
        )
    }

}
package com.example.roombase.data.models

import android.os.Parcelable
import com.example.roombase.data.database.entities.EanCodeEntity
import kotlinx.parcelize.Parcelize

@Parcelize
class EanCodeBo(
    var eanCode: String,
    var productId: Long,
) : Parcelable, BaseBo<EanCodeEntity> {
    override fun toEntity(): EanCodeEntity {
        return EanCodeEntity(
            eanCode = eanCode,
            productId = productId
        )
    }
}
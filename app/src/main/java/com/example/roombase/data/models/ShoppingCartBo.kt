package com.modelorama.pos.domain.model.bo

import android.os.Parcelable
import com.example.roombase.data.models.BaseBo
import com.modelorama.pos.data.database.entities.ShoppingCartEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoppingCartBo(
    var shoppingCartId: Long,
    var status: String = "",
    var total: String = "",
    var totalDiscount: String
) : Parcelable, BaseBo<ShoppingCartEntity> {

    override fun toEntity(): ShoppingCartEntity =
        ShoppingCartEntity(
            shoppingCartId = shoppingCartId,
            status = status,
            total = total,
            totalDiscount = totalDiscount)

}
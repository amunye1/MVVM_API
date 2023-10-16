package com.tc.beerlist.data.model.beer


import com.google.gson.annotations.SerializedName

data class MaltModel(
    @SerializedName("amount")
    val amount: AmountModel? = AmountModel(),
    @SerializedName("name")
    val name: String? = ""
)
package com.tc.beerlist.data.model.beer


import com.google.gson.annotations.SerializedName

data class MethodModel(
    @SerializedName("fermentation")
    val fermentation: FermentationModel? = FermentationModel(),
    @SerializedName("mash_temp")
    val mashTemp: List<MashTempModel>? = listOf(),
    @SerializedName("twist")
    val twist: String? = ""
)
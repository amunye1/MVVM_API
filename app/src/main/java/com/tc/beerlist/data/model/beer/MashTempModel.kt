package com.tc.beerlist.data.model.beer


import com.google.gson.annotations.SerializedName

data class MashTempModel(
    @SerializedName("duration")
    val duration: Int? = 0,
    @SerializedName("temp")
    val temp: TempModel? = TempModel()
)
package com.ae.acronymapp.dto

import com.google.gson.annotations.SerializedName

data class MeaningResponse(
    @SerializedName("sf")
    val abbreviation: String = "",
    @SerializedName("lfs")
    val longFormArray: List<LongFormArray> = arrayListOf()
)

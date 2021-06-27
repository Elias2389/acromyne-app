package com.ae.acronymapp.dto

import com.google.gson.annotations.SerializedName

data class LongFormArray(
    @SerializedName("lf")
    val longForm: String = "",
    @SerializedName("freq")
    val freq: Int = 0,
    @SerializedName("since")
    val since: Int = 0,
    @SerializedName("vars")
    val variationObjects: List<VariationObject> = arrayListOf()
)

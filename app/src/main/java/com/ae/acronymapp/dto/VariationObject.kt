package com.ae.acronymapp.dto

import com.google.gson.annotations.SerializedName

data class VariationObject(
    @SerializedName("lf")
    val lfVariant: String = "",
    @SerializedName("freq")
    val freq: Int = 0,
    @SerializedName("since")
    val since: Int = 0
)

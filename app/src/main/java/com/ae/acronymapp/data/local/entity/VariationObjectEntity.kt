package com.ae.acronymapp.data.local.entity

import com.google.gson.annotations.SerializedName

data class VariationObjectEntity(
    @SerializedName("lf")
    val lfVariant: String,
    @SerializedName("freq")
    val freq: Int = 0,
    @SerializedName("since")
    val since: Int = 0
)

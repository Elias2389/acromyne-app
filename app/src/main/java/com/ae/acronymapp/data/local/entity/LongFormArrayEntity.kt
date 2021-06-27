package com.ae.acronymapp.data.local.entity

import com.google.gson.annotations.SerializedName

data class LongFormArrayEntity(
    @SerializedName("lf")
    val longForm: String = "",
    @SerializedName("freq")
    val freq: Int = 0,
    @SerializedName("since")
    val since: Int = 0,
    @SerializedName("vars")
    val variationObjects: List<VariationObjectEntity> = arrayListOf(),
)

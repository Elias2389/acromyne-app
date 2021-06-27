package com.ae.acronymapp.util

import com.ae.acronymapp.dto.LongFormArray
import com.ae.acronymapp.dto.MeaningResponse
import com.ae.acronymapp.dto.VariationObject

fun getListMeaningResponseMock(): List<MeaningResponse> {
    return arrayListOf(
        getMeaningResponseMock()
    )
}

fun getMeaningResponseMock(): MeaningResponse {
    return MeaningResponse(
        abbreviation = "HMM",
        longFormArray = getListLongFormArrayMock()
    )
}

fun getListLongFormArrayMock(): List<LongFormArray> {
    return arrayListOf<LongFormArray>(
        getLongFormArrayMock().copy(since = 1900),
        getLongFormArrayMock().copy(since = 1500)
    )
}

fun getLongFormArrayMock(): LongFormArray {
    return LongFormArray(
        longForm = "heavy meromyosin",
        freq = 12,
        since = 1800,
        variationObjects = getListVariationObjectMock()
    )
}

fun getListVariationObjectMock(): List<VariationObject> {
    return arrayListOf<VariationObject>(
        getVariationObjectMock().copy(lfVariant = "H-meromyosin"),
        getVariationObjectMock()
    )
}

fun getVariationObjectMock(): VariationObject {
    return VariationObject(
        lfVariant = "heavy meromyosin",
        since = 20,
        freq = 1800
    )
}

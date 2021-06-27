package com.ae.acronymapp.util

import com.ae.acronymapp.data.local.entity.LongFormArrayEntity
import com.ae.acronymapp.data.local.entity.MeaningResponseEntity
import com.ae.acronymapp.data.local.entity.VariationObjectEntity
import com.ae.acronymapp.dto.LongFormArray
import com.ae.acronymapp.dto.MeaningResponse
import com.ae.acronymapp.dto.VariationObject

/**
 * Converter VariationObject to
 * VariationObjectEntity
 */
fun VariationObject.toVariationObjectEntity() = VariationObjectEntity(
    lfVariant = lfVariant,
    freq = freq,
    since = since
)

/**
 * Converter List VariationObject to
 *  List VariationObjectEntity
 */
fun List<VariationObject>.toVariationObjectEntity(): List<VariationObjectEntity> {
    return this.map { it.toVariationObjectEntity() }
}

/**
 * Converter VariationObjectEntity to
 * VariationObject
 */
fun VariationObjectEntity.toVariationObject() = VariationObject(
    lfVariant = lfVariant,
    freq = freq,
    since = since
)

/**
 * Converter List VariationObject to
 *  List VariationObjectEntity
 */
fun List<VariationObjectEntity>.toVariationObject(): List<VariationObject> {
    return this.map { it.toVariationObject() }
}

/**
 * Converter VariationObject to
 * VariationObjectEntity
 */
fun LongFormArrayEntity.toLongFormArray() = LongFormArray(
    longForm = longForm,
    freq = freq,
    since = since,
    variationObjects = variationObjects.toVariationObject()
)

/**
 * Converter List LongFormArrayEntity to
 * List LongFormArray
 */
fun List<LongFormArrayEntity>.toLongFormArray(): List<LongFormArray> {
    return this.map { it.toLongFormArray() }
}

/**
 * Converter LongFormArray to
 * LongFormArrayEntity
 */
fun LongFormArray.toLongFormAArray() = LongFormArrayEntity(
    longForm = longForm,
    freq = freq,
    since = since,
    variationObjects = variationObjects.toVariationObjectEntity()
)

/**
 * Converter List LongFormArray to
 * List LongFormArrayEntity
 */
fun List<LongFormArray>.toLongFormArrayEntity(): List<LongFormArrayEntity> {
    return this.map { it.toLongFormAArray() }
}

/**
 * Converter MeaningResponse to
 * MeaningResponseEntity
 */
fun MeaningResponse.toMeaningResponseEntity() = MeaningResponseEntity(
    abbreviation = abbreviation,
    longFormArray = longFormArray.toLongFormArrayEntity()
)

/**
 * Converter List LongFormArray to
 * List LongFormArrayEntity
 */
fun List<MeaningResponse>.toMeaningResponseEntity(): List<MeaningResponseEntity> {
    return this.map { it.toMeaningResponseEntity() }
}

/**
 * Converter MeaningResponseEntity to
 * MeaningResponse
 */
fun MeaningResponseEntity.toMeaningResponse() = MeaningResponse(
    abbreviation = abbreviation,
    longFormArray = longFormArray.toLongFormArray()
)

/**
 * Converter List MeaningResponseEntity to
 * List MeaningResponse
 */
fun List<MeaningResponseEntity>.toMeaningResponse(): List<MeaningResponse> {
    return this.map { it.toMeaningResponse() }
}

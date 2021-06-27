package com.ae.acronymapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "meaning_entity")
data class MeaningResponseEntity(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @SerializedName("sf")
    @ColumnInfo(name = "abbreviation")
    val abbreviation: String = "",
    @TypeConverters(LongFormArrayTypeConverter::class)
    @SerializedName("lfs")
    @ColumnInfo(name = "longFormArray")
    val longFormArray: List<LongFormArrayEntity> = arrayListOf(),
    @ColumnInfo(name = "created_at")
    var createAt: Long = System.currentTimeMillis()
)

package com.bulich.misha.workwithremotedb.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FilmsApiModel(
    @SerializedName("id") @Expose
    val id: Int? = null,
    @SerializedName("name") @Expose
    val name: String? = null,
    @SerializedName("image")
    val image: String? = null
)

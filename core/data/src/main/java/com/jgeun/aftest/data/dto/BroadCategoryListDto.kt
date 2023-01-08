package com.jgeun.aftest.data.dto

import com.google.gson.annotations.SerializedName

data class BroadCategoryListDto(
    @SerializedName("broad_category")
    val broadCategory: List<BroadCategoryDto>
)

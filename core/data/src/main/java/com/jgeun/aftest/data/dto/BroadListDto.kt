package com.jgeun.aftest.data.dto

import com.google.gson.annotations.SerializedName

data class BroadListDto(
    @SerializedName("total_cnt")
    val totalCnt: Int,
    @SerializedName("page_no")
    val pageNo: Int,
    val broad: List<BroadDto>,
    val time: Long
)

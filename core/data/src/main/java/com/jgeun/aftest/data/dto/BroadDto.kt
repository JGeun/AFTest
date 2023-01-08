package com.jgeun.aftest.data.dto

import com.google.gson.annotations.SerializedName

data class BroadDto(
    @SerializedName("broad_title")
    val broadTitle: String,
    @SerializedName("visit_broad_type")
    val visit_broad_type: String,
    @SerializedName("is_password")
    val isPassword: Int,
    @SerializedName("broad_cate_no")
    val broadCateNo: String,
    @SerializedName("broad_no")
    val broadNo: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_nick")
    val userNick: String,
    @SerializedName("profile_img")
    val profileImg: String,
    @SerializedName("broad_thumb")
    val broadThumb: String,
    @SerializedName("broad_start")
    val broadStart: String,
    @SerializedName("broad_grade")
    val broadGrade: String,
    @SerializedName("broad_bps")
    val broadBps: String,
    @SerializedName("broad_resolution")
    val broadResolution: String,
    @SerializedName("total_view_cnt")
    val totalViewCnt: String
)

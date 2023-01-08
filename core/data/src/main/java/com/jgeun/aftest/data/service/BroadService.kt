package com.jgeun.aftest.data.service

import com.jgeun.aftest.data.dto.BroadCategoryListDto
import com.jgeun.aftest.data.dto.BroadListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BroadService {

    @GET("broad/list")
    suspend fun fetchBroadList(@Query("select_value") selectValue: String, @Query("page_no") pageNo: Int): BroadListDto

    @GET("broad/category/list")
    suspend fun fetchBroadCategoryList(): BroadCategoryListDto
}
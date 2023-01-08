package com.jgeun.aftest.data.repository

import com.jgeun.aftest.data.dto.BroadCategoryListDto
import com.jgeun.aftest.data.dto.BroadListDto
import kotlinx.coroutines.flow.Flow

/**
 * Data layer [BroadListDto], [BroadCategoryListDto]를 사용
 */
interface BroadRepository {

    suspend fun fetchBroadList(broadCateNo: String, pageNo: Int) : Flow<BroadListDto>

    suspend fun fetchBroadCategoryList() : Flow<BroadCategoryListDto>
}
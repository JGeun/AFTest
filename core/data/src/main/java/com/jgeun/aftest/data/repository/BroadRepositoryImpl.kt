package com.jgeun.aftest.data.repository

import com.jgeun.aftest.data.dto.BroadCategoryListDto
import com.jgeun.aftest.data.dto.BroadListDto
import com.jgeun.aftest.data.service.BroadService
import com.jgeun.aftest.network.exception.NetworkFailureException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * [BroadRepository]의 구현체
 * 카테고리 리스트, 카테고리별 영상들을 가져옴
 */
class BroadRepositoryImpl @Inject constructor(
    private val broadService: BroadService
) : BroadRepository {

    // 카테고리별 영상들을 가져오는 함수
    override suspend fun fetchBroadList(broadCateNo: String, pageNo: Int): Flow<BroadListDto> {
        return flow {
            val broadList = broadService.fetchBroadList(broadCateNo, pageNo)
            emit(broadList)
        }.catch {
            throw NetworkFailureException("Network Error ${it.message}")
        }
    }

    // 카테고리 리스트를 가져오는 함수
    override suspend fun fetchBroadCategoryList(): Flow<BroadCategoryListDto> {
        return flow {
            val broadCategoryList = broadService.fetchBroadCategoryList()
            emit(broadCategoryList)
        }.catch {
            throw NetworkFailureException("Network Error ${it.message}")
        }
    }

}
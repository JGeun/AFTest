package com.jgeun.aftest.domain.usecase

import com.jgeun.aftest.data.repository.BroadRepository
import com.jgeun.aftest.domain.translator.BroadTranslator.toBroads
import com.jgeun.aftest.domain.vo.BroadListVO
import com.jgeun.aftest.domain.vo.CategoryBroadsVO
import com.jgeun.aftest.network.exception.NetworkFailureException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 카테고리별 영상 리스트를 가져오는 [GetNextBroadsUseCase]의 구현체입니다.
 */
class GetNextBroadsUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetNextBroadsUseCase {

    override fun invoke(categoryBroad: CategoryBroadsVO): Flow<CategoryBroadsVO> {
        val broadCateNo = categoryBroad.cateNo
        val nextPageNo = categoryBroad.broadList.pageNo+1

        return flow {
            broadRepository.fetchBroadList(broadCateNo, nextPageNo).collect {

                val prevBroads = categoryBroad.broadList.broad.toMutableList()
                prevBroads.addAll(it.broad.toBroads())

                val broadList = BroadListVO(
                    it.totalCnt,
                    it.pageNo,
                    prevBroads.toList(),
                    it.time
                )

                val result = CategoryBroadsVO(
                    categoryBroad.cateNo,
                    categoryBroad.cateName,
                    broadList,
                )

                emit(result)
            }
        }.catch {
            throw NetworkFailureException("Network Error ${it.message}")
        }
    }
}
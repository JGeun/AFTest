package com.jgeun.aftest.domain.usecase

import com.jgeun.aftest.data.repository.BroadRepository
import com.jgeun.aftest.domain.translator.BroadTranslator.toBroadList
import com.jgeun.aftest.domain.vo.BroadListVO
import com.jgeun.aftest.network.exception.NetworkFailureException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 카테고리별 영상 리스트를 가져오는 UseCase입니다.
 */
class GetCategoryBroadsUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetCategoryBroadsUseCase {

    override fun invoke(broadCateNo: String, pageNo: Int): Flow<BroadListVO> {
        return flow {
            broadRepository.fetchBroadList(broadCateNo, pageNo).collect {


                emit(it.toBroadList())
            }
        }.catch {
            throw NetworkFailureException("Network Error ${it.message}")
        }
    }
}
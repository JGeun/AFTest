package com.jgeun.aftest.domain.usecase

import com.jgeun.aftest.data.repository.BroadRepository
import com.jgeun.aftest.domain.translator.BroadTranslator.toBroadCategoryList
import com.jgeun.aftest.domain.vo.CategoryVO
import com.jgeun.aftest.network.exception.NetworkFailureException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 카테고리 리스트를 가져오는 [GetBroadCategoriesUseCase]의 구현체입니다.
 */
class GetBroadCategoriesUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetBroadCategoriesUseCase {

    override fun invoke(): Flow<List<CategoryVO>> {
        return flow {
            broadRepository.fetchBroadCategoryList().collect {
                emit(it.broadCategory.toBroadCategoryList())
            }
        }.catch {
            throw NetworkFailureException("Network Error ${it.message}")
        }
    }
}
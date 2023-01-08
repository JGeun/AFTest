package com.jgeun.aftest.domain.usecase

import com.jgeun.aftest.domain.vo.CategoryVO
import kotlinx.coroutines.flow.Flow

/**
 * 카테고리 리스트를 가져오는 UseCase입니다.
 */
interface GetBroadCategoriesUseCase {
    operator fun invoke(): Flow<List<CategoryVO>>
}
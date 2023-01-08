package com.jgeun.aftest.domain.usecase

import com.jgeun.aftest.domain.vo.CategoryBroadsVO
import kotlinx.coroutines.flow.Flow

/**
 * 다음 페이지의 카테고리별 영상 리스트를 가져오는 UseCase입니다.
 */
interface GetNextBroadsUseCase {
    operator fun invoke(categoryBroad: CategoryBroadsVO): Flow<CategoryBroadsVO>
}
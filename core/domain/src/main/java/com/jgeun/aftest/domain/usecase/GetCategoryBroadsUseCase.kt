package com.jgeun.aftest.domain.usecase

import com.jgeun.aftest.domain.vo.BroadListVO
import kotlinx.coroutines.flow.Flow

/**
 * 카테고리별 영상 리스트를 가져오는 UseCase입니다.
 */
interface GetCategoryBroadsUseCase {
    operator fun invoke(broadCateNo: String = "", pageNo: Int = 1): Flow<BroadListVO>
}
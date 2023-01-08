package com.jgeun.aftest.domain.translator

import com.jgeun.aftest.data.dto.BroadCategoryDto
import com.jgeun.aftest.data.dto.BroadDto
import com.jgeun.aftest.data.dto.BroadListDto
import com.jgeun.aftest.domain.vo.BroadListVO
import com.jgeun.aftest.domain.vo.BroadVO
import com.jgeun.aftest.domain.vo.CategoryVO

object BroadTranslator {

    /**
     * DataLayer의 [BroadDto]를 비즈니스로직인 [BroadVO]로 변환합니다.
     */
    fun List<BroadDto>.toBroads(): List<BroadVO> {
        val broads = mutableListOf<BroadVO>()
        this.forEach { broadData ->
            broads.add(
                BroadVO(
                    broadTitle = broadData.broadTitle,
                    broadCateNo = broadData.broadCateNo,
                    broadThumb = "https:${broadData.broadThumb}",
                    broadNo = broadData.broadNo,
                    userId = broadData.userId,
                    userNick = broadData.userNick,
                    profileImg = "https:${broadData.profileImg}",
                    broadResolution = broadData.broadResolution,
                    totalViewCnt = broadData.totalViewCnt
                )
            )
        }
        return broads.toList()
    }

    /**
     * DataLayer의 [BroadListDto]를 비즈니스로직인 [BroadListVO]로 변환합니다.
     */
    fun BroadListDto.toBroadList(): BroadListVO {
        return BroadListVO(
            totalCnt = totalCnt,
            pageNo = pageNo,
            broad = broad.toBroads(),
            time = time
        )
    }

    /**
     * DataLayer의 [BroadCategoryDto]를 비즈니스로직인 [CategoryVO]로 변환합니다.
     */
    fun List<BroadCategoryDto>.toBroadCategoryList(): List<CategoryVO> {
        val broadCategories = mutableListOf<CategoryVO>()

        this.forEach { broadCategoryData ->
            broadCategories.add(
                CategoryVO(
                    broadCategoryData.cateName,
                    broadCategoryData.cateNo,
                    broadCategoryData.child?.toBroadCategoryList()
                )
            )
        }

        return broadCategories.toList()
    }
}
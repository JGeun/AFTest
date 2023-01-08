package com.jgeun.aftest.domain.vo

data class BroadListVO(
    val totalCnt: Int,
    val pageNo: Int,
    val broad: List<BroadVO>,
    val time: Long
) : java.io.Serializable {
    companion object {
        val EMPTY = BroadListVO(0, 0, emptyList(), 0L)
    }
}

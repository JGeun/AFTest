package com.jgeun.aftest.common_ui.vo

import java.io.Serializable

/**
 * BroadInfo에 필요한 View데이터를 관리하는 객체
 */
data class BroadInfoViewArgument(
    val title: String,
    val thumb: String,
    val profileImg: String,
    val nickname: String,
    val totalViewCnt: String
) : Serializable
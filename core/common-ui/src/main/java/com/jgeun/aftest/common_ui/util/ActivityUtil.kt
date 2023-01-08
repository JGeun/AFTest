package com.jgeun.aftest.common_ui.util

import com.jgeun.aftest.common_ui.vo.BroadInfoViewArgument

/**
 * Activity를 필요로하는 기능을 명시하고 [MainActivity]에서 구현합니다
 */
interface ActivityUtil {
    fun navigateToBroadInfo(broadInfo: BroadInfoViewArgument)
}
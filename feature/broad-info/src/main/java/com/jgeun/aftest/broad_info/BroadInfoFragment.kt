package com.jgeun.aftest.broad_info

import com.jgeun.aftest.common_ui.base.BaseFragment
import com.jgeun.aftest.common_ui.vo.BroadInfoViewArgument
import com.jgeun.aftest.feature.broad_info.R
import com.jgeun.aftest.feature.broad_info.databinding.FragmentBroadInfoBinding

class BroadInfoFragment : BaseFragment<FragmentBroadInfoBinding>(R.layout.fragment_broad_info) {

    override fun initView() {
        val broadInfoData = arguments?.getSerializable("broadInfo") as BroadInfoViewArgument

        bind {
            broadInfo = broadInfoData
        }
    }
}
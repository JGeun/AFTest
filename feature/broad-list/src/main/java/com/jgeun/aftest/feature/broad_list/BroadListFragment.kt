package com.jgeun.aftest.feature.broad_list

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jgeun.aftest.common_ui.base.BaseFragment
import com.jgeun.aftest.common_ui.util.ActivityUtil
import com.jgeun.aftest.feature.broad_list.databinding.FragmentBroadListBinding
import dagger.hilt.android.AndroidEntryPoint

private const val POSITION = "position"

@AndroidEntryPoint
class BroadListFragment : BaseFragment<FragmentBroadListBinding>(R.layout.fragment_broad_list) {

    private val viewModel by viewModels<BroadViewModel>(ownerProducer = { requireParentFragment() })
    private lateinit var broadAdapter: BroadAdapter

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            position = it.getInt(POSITION)
        }
    }

    override fun initView() {

        broadAdapter = BroadAdapter(requireContext()) { broadPos ->
            (activity as ActivityUtil).navigateToBroadInfo(viewModel.getBroadInfo(position, broadPos))
        }

        val scrollListener: RecyclerView.OnScrollListener = object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = binding.broadRv.layoutManager
                val lastVisibleItem = (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()

                // 마지막 아이템 - 5번째가 보여질 경우 다음 페이지 데이터를 가져옵니다
                if (layoutManager.itemCount <= lastVisibleItem + 5) {
                    viewModel.fetchNextBroadList(position)
                }
            }
        }

        bind {
            vm = viewModel
            categoryPos = position
            adapter = broadAdapter
            itemDecoration = BroadListItemDecoration(20)
            rvFixedOption = true
            rvScrollListener = scrollListener
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            BroadListFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                }
            }
    }
}
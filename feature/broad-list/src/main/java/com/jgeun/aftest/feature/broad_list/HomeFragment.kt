package com.jgeun.aftest.feature.broad_list

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jgeun.aftest.common_ui.base.BaseFragment
import com.jgeun.aftest.feature.broad_list.databinding.FragmentBroadBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentBroadBinding>(R.layout.fragment_broad) {

    private val viewModel by viewModels<BroadViewModel>()

    override fun initView() {

        lifecycleScope.launchWhenStarted {
            viewModel.categories.collectLatest {
                if (it.isEmpty()) return@collectLatest

                val categoryBroadListAdapter = BroadListPagerAdapter(
                    childFragmentManager,
                    lifecycle,
                    viewModel.categories.value.size
                )

                binding.categoryBroadVp.apply {
                    adapter = categoryBroadListAdapter
                    orientation = ViewPager2.ORIENTATION_HORIZONTAL
                }

                TabLayoutMediator(binding.categoryTab, binding.categoryBroadVp) { tab, position ->
                    tab.text = it[position].cateName
                }.attach()
            }
        }
    }

}
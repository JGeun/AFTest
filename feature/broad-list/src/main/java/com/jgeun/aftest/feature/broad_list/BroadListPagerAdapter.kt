package com.jgeun.aftest.feature.broad_list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BroadListPagerAdapter(fa: FragmentManager, lifecycle: Lifecycle, private val count: Int) : FragmentStateAdapter(fa, lifecycle) {
    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment = BroadListFragment.newInstance(position)
}
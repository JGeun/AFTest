package com.jgeun.aftest.feature.broad_list

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jgeun.aftest.common_ui.result.UiState
import com.jgeun.aftest.common_ui.result.data
import com.jgeun.aftest.domain.vo.CategoryBroadsVO

@BindingAdapter("broads", "categoryPos")
fun RecyclerView.bindBroads(state: UiState<List<CategoryBroadsVO>>, categoryPos: Int) {
    val boundAdapter = this.adapter
    if (boundAdapter is BroadAdapter) {
        if (state.data == null) return
        boundAdapter.submitList(state.data!![categoryPos].broadList.broad)
    }
}
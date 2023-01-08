package com.jgeun.aftest.feature.broad_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jgeun.aftest.domain.vo.BroadVO
import com.jgeun.aftest.feature.broad_list.databinding.ItemBroadListBinding

class BroadAdapter(private val context: Context, private val onClicked: (broadPos: Int) -> Unit) : ListAdapter<BroadVO, BroadAdapter.ViewHolder>(BroadCategoryListDiffCallback) {

    private lateinit var binding: ItemBroadListBinding
    private val ITEM_PRELOAD_CNT = 6

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemBroadListBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClicked(position)
        }
        holder.bind(getItem(position))

        imagePreload(position) // 하단 이미지 preload을 통해 유저에게 보여지는 이미지로딩 시간 단축
    }

    class ViewHolder(private val binding: ItemBroadListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BroadVO) {
            binding.broad = item
        }
    }

    // 현재 보여지는 item 뒤의 6개 이미지에 대해서 Preload를 실행합니다
    private fun imagePreload(position: Int) {
        if (position <= itemCount) {
            val endPosition = if (position + ITEM_PRELOAD_CNT> itemCount) {
                itemCount
            } else {
                position + ITEM_PRELOAD_CNT
            }
            currentList.subList(position, endPosition).map { it.broadThumb }.forEach {
                Glide.with(context).load(it).preload()
            }

            currentList.subList(position, endPosition).map { it.profileImg }.forEach {
                Glide.with(context).load(it).preload()
            }
        }
    }

    object BroadCategoryListDiffCallback : DiffUtil.ItemCallback<BroadVO>() {
        override fun areItemsTheSame(oldItem: BroadVO, newItem: BroadVO): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BroadVO, newItem: BroadVO): Boolean {
            return oldItem.broadNo == newItem.broadNo
        }
    }

}
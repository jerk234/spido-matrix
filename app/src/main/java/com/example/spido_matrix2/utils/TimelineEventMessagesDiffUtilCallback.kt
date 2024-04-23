package com.example.spido_matrix2.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.spido_matrix2.data.TimelineEventMessageWrapper

class TimelineEventMessagesDiffUtilCallback(
    private val oldList: List<TimelineEventMessageWrapper>,
    private val newList: List<TimelineEventMessageWrapper>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}

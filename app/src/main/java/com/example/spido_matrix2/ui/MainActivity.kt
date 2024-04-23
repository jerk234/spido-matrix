package com.example.spido_matrix2.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.example.spido_matrix2.data.TimelineEventMessageWrapper
import com.example.spido_matrix2.R
import com.example.spido_matrix2.SessionHolder


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

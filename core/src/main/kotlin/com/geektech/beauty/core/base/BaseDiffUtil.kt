package com.geektech.beauty.core.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtil<T : BaseDiffModel<S>, S> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.nameService == newItem.nameService

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}
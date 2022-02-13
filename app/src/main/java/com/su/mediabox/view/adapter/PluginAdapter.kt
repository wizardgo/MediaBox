package com.su.mediabox.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.su.mediabox.bean.PluginInfo
import com.su.mediabox.databinding.ItemPluginBinding
import com.su.mediabox.util.setOnClickListener

class PluginAdapter : ListAdapter<PluginInfo, PluginAdapter.ItemPluginViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemPluginViewHolder(parent).apply {
            //UP_TODO 2022/2/13 21:46 0 验证、启动
            setOnClickListener(viewBinding.root) {
                getItem(it)?.also {

                }
            }
        }

    override fun onBindViewHolder(holder: ItemPluginViewHolder, position: Int) {
        getItem(position)?.apply {
            holder.viewBinding.apply {
                pluginIcon.setImageDrawable(icon)
                pluginName.text = name
            }
        }
    }

    class ItemPluginViewHolder private constructor(val viewBinding: ItemPluginBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        constructor(parent: ViewGroup) : this(
            ItemPluginBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    object Diff : DiffUtil.ItemCallback<PluginInfo>() {

        override fun areItemsTheSame(oldItem: PluginInfo, newItem: PluginInfo): Boolean =
            oldItem.packageName == newItem.packageName

        override fun areContentsTheSame(oldItem: PluginInfo, newItem: PluginInfo): Boolean =
            oldItem.icon.hashCode() == newItem.icon.hashCode() &&
                    oldItem.name == newItem.name
    }
}
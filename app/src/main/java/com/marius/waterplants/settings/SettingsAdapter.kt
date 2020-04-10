package com.marius.waterplants.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.marius.waterplants.R

import kotlinx.android.synthetic.main.setting_item_view.view.setting_name_text_view as settingName
import kotlinx.android.synthetic.main.setting_item_view.view.setting_value_text_view as settingValue

class SettingsAdapter : ListAdapter<Setting, SettingViewHolder>(SettingDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.setting_item_view, parent, false)
        return SettingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SettingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(setting: Setting) = with(itemView) {
        settingName.text = setting.name
        settingValue.text = setting.value
    }
}

private class SettingDiffCallback : DiffUtil.ItemCallback<Setting>() {

    override fun areItemsTheSame(oldItem: Setting, newItem: Setting) = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Setting, newItem: Setting) = oldItem == newItem
}

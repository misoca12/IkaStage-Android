package com.misoca.ikastage.presentation.match

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.misoca.ikastage.R
import com.misoca.ikastage.data.model.Match
import com.misoca.ikastage.databinding.MatchAdapterItemBinding

class MatchAdapter: RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    val items = ArrayList<Match>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate<MatchAdapterItemBinding>(
                LayoutInflater.from(parent.context), R.layout.match_adapter_item, parent, false))
    }

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {
        holder.binding.match = items[position]
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val binding: MatchAdapterItemBinding) : RecyclerView.ViewHolder(binding.root)
}

package com.misoca.ikastage.presentation.coop

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.misoca.ikastage.R
import com.misoca.ikastage.data.model.Coop
import com.misoca.ikastage.databinding.CoopAdapterItemBinding

class CoopAdapter: RecyclerView.Adapter<CoopAdapter.ViewHolder>() {
    val items = ArrayList<Coop>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoopAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate<CoopAdapterItemBinding>(
                LayoutInflater.from(parent.context), R.layout.coop_adapter_item, parent, false))
    }

    override fun onBindViewHolder(holder: CoopAdapter.ViewHolder, position: Int) {
//        val business = businesses.businesses!![position]
//        holder.binding.setVariable(BR.viewModel, BusinessesItemViewModel(business))
//        holder.binding.executePendingBindings()
    }

    override fun onBindViewHolder(holder: CoopAdapter.ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val binding: CoopAdapterItemBinding) : RecyclerView.ViewHolder(binding.root)
}

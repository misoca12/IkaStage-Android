package com.misoca.ikastage.presentation.coop

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.misoca.ikastage.R
import com.misoca.ikastage.data.model.Coop

class CoopAdapter (private val context: Context, private val coops: List<Coop>) : RecyclerView.Adapter<CoopAdapter.ItemViewHolder>() {

    class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ViewDataBinding
        init {
            // Bind処理
            this.binding = DataBindingUtil.bind<ViewDataBinding>(v)!!
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.coop_adapter_item, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val business = businesses.businesses!![position]
//        holder.binding.setVariable(BR.viewModel, BusinessesItemViewModel(business))
//        holder.binding.executePendingBindings()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        return coops.size
    }

}

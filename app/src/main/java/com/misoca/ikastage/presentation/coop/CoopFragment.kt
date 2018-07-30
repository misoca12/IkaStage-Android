package com.misoca.ikastage.presentation.coop

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.misoca.ikastage.data.model.CoopResponse

import com.misoca.ikastage.databinding.CoopFragmentBinding
import dagger.android.support.DaggerFragment // Supportを入れないとv4のFragmentが使われない
import timber.log.Timber
import javax.inject.Inject

class CoopFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CoopViewModel
    private lateinit var binding: CoopFragmentBinding
    private val adapter = CoopAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        CoopFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(CoopViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.coopResponse.observe(this, Observer<CoopResponse> {
            Timber.d("Observer onChanged")
            it ?: return@Observer
            it.result ?: return@Observer
            adapter.run {
                items.clear()
                items.addAll(it.result)
                notifyDataSetChanged()
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoopFragment()
    }
}

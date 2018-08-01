package com.misoca.ikastage.presentation.match

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.misoca.ikastage.data.model.MatchResponse

import com.misoca.ikastage.databinding.MatchFragmentBinding
import dagger.android.support.DaggerFragment // Supportを入れないとv4のFragmentが使われない
import timber.log.Timber
import javax.inject.Inject

class MatchFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MatchViewModel
    private lateinit var binding: MatchFragmentBinding
    private val adapter = MatchAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        MatchFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // ここでthisを渡すことでViewPager内の各Fragment毎にViewModelを生成する
        // activityを渡した場合は同じViewPager内の各Fragmentは同じViewModelを参照する
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MatchViewModel::class.java)

        // LiveData Setting
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        // RecyclerView Setting
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        // 画面に反映する
        viewModel.matchResponse.observe(this, Observer<MatchResponse> {
            Timber.d("Observer onChanged")
            it ?: return@Observer
            it.result ?: return@Observer
            adapter.run {
                items.clear()
                items.addAll(it.result)
                notifyDataSetChanged()
            }
        })
        viewModel.match.value = arguments?.getString("match")
    }

    companion object {
        @JvmStatic
        fun newInstance(match: String) = MatchFragment().apply {
            arguments = Bundle().apply {
                putString("match", match)
            }
        }
    }
}

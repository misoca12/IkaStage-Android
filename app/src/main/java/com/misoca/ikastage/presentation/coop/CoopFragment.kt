package com.misoca.ikastage.presentation.coop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.misoca.ikastage.databinding.CoopFragmentBinding
import dagger.android.support.DaggerFragment // Supportを入れないとv4のFragmentが使われない
import javax.inject.Inject

class CoopFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: CoopViewModel

    lateinit var binding: CoopFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = CoopFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        val view = binding.root
        return view
    }

    override fun onResume() {
        super.onResume()
        binding.viewModel!!.loadCoop()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoopFragment().apply {
            arguments = Bundle().apply {
                // パラメータが必要な場合はここでセットする
            }
        }
    }
}
